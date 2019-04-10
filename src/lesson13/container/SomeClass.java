package lesson13.container;


public class SomeClass {


    SomeClassContainer container;

    public SomeClass()
    {
    }

    public SomeClassContainer getContainer() {
        return container;
    }

    public void setContainer(SomeClassContainer container) {
        this.container = container;
    }

    @Override
    public String toString() {
        return "Someclass{" +
                "config=" + container +
                '}';
    }
}