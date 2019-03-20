package animals;

public class Cat extends Animal implements Run, Eat{


    @Override
    public void run() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void stop() {
        System.out.println("Cat stop");
    }
}
