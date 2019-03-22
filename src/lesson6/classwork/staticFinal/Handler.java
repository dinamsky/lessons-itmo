package lesson6.classwork.staticFinal;

public interface Handler {
    public void read();
    public void write();
    public static Handler getInstance(String fileName){
        Handler handler = null;
        if(fileName.endsWith(".xml")){
            handler = new XmlHandler();
        } else if (fileName.endsWith(".json")){
            handler= new JsonHandler();
        }
        return handler;

    }

}
class XmlHandler implements Handler{
    @Override
    public void read() {
        System.out.println("Xml read");

    }

    @Override
    public void write() {
        System.out.println("Xml write");

    }
}

class JsonHandler implements Handler {
    @Override
    public void read() {
        System.out.println("Json read");

    }

    @Override
    public void write() {
        System.out.println("Json write");

    }
}
