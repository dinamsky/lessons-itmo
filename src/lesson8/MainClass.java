package lesson8;

public class MainClass {
    private  void someVoid2(){
        int a = 14;
        String str = "String";
    }
    public void someVoid(){
        int a = 12;
        someVoid2();
    }

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        mainClass.someVoid();
    }
}
