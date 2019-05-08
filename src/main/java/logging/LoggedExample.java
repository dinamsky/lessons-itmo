package logging;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.*;

public class LoggedExample {
    private static final Logger LOGGER = Logger.getLogger(LoggedExample.class.getName());
    static {
//        LOGGER.setLevel(Level.SEVERE);// фатальные
//        LOGGER.setLevel(Level.WARNING);
//        LOGGER.setLevel(Level.INFO);
        LOGGER.setLevel(Level.ALL);

//        LOGGER.setLevel(Level.CONFIG);
//        LOGGER.setLevel(Level.FINE);
//        LOGGER.setLevel(Level.FINER);
//        LOGGER.setLevel(Level.FINEST);
        try {
            LOGGER.addHandler(new FileHandler("loggedExample.log.xml"));

            FileHandler fileHandler = new FileHandler("loggedExample.log");
            fileHandler.setFormatter(new CustomFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.warning("FileHandler not accesible");
        }
    }

    public static void main(String[] args) {
        LOGGER.info("Program started with args"+ Arrays.toString(args));
        try{
            int res=2/0;
        }catch(Exception e){
            LOGGER.severe("zero division");
        }

    }
}

class CustomFormatter extends Formatter {
    private final static ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>(){
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    @Override
    public String format(LogRecord record) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[').append(formatDate(record.getMillis())).append(']');
        stringBuilder.append('[').append(record.getLevel()).append(']');
        stringBuilder.append('[').append(record.getParameters()).append(']');
        stringBuilder.append('[').append(record.getSourceClassName()).append(']');
        stringBuilder.append('[').append(record.getSourceMethodName()).append(']');
        stringBuilder.append('[').append(record.getMessage()).append(']');
        stringBuilder.append('[').append("OMG its a funky shit").append(']');
        return stringBuilder.toString();
    }
    private String formatDate(long millis){
        return dateFormat.get().format(new Date(millis));
    }
}
