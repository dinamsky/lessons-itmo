package animals;

public abstract class AbstractClass {
    public abstract void abstractVoid();
    public void someVoid(){
        System.out.println("someVoid");
    }
}

interface SomeInterface {
    public void iVoid();
}
class SomeClass extends AbstractClass {
    @Override
    public void abstractVoid() {
        System.out.println("Реализация метода абстрактного класса");
    }


}