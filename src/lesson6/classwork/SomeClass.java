package lesson6.classwork;

public class SomeClass {
    public static  SomeClass instance;

    public static final SomeClass getInstance(){

        return new SomeClass();
    }


    public void ptintInfo(String string){
        System.out.println("info"+string);
    }
}
class SomeClass2 {
    public void SomeVoid(){
        SomeClass someClass = SomeClass.getInstance();
        SomeClass someClass1 = SomeClass.getInstance();
        SomeClass someClass2 = SomeClass.getInstance();
        someClass.ptintInfo("ghjcnbnent");
    }
}