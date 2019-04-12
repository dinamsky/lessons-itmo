package patterns.startegy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ILogger {
    @Override
    public void write(String info) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt",true))){
            writer.write("omg"+info);
        }catch(IOException o){
            o.printStackTrace();
        }
    }
}
