package lesson6.classwork.staticFinal;

public class Main {
    public static void main(String[] args) {
        String fileName = "file.json";
        //вызов статического метода
        Handler handler = Handler.getInstance(fileName);
        handler.read();
        String fileName2 = "file.xml";
        //вызов статического метода
        Handler handler2 = Handler.getInstance(fileName);
        handler2.write();
        System.out.println(CalcUtils.sum(3,6));


    }
}
