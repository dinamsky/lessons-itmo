package lesson6.classwork.nested;

public interface Logger {
    public void log();
}

class SomeClass{
    public void someVoid(){
        //анонимный класс
        Logger logger = new Logger(){
            @Override
            public void log(){
                System.out.println("Log smth");
            }
        };
        logger.log();
    }
}
