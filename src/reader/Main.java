package reader;

public class Main  {
    public static void getRead(Read read){
        read.read();
    }
    public static void main(String[] args) {
        Read jsonhandler = new JSONHandler();
        getRead(jsonhandler);



    }
}
