package lesson6.classwork;

public class Sing {
    private static Sing ourInstance = new Sing();

    public static Sing getInstance() {
        return ourInstance;
    }

    private Sing() {
    }
}
