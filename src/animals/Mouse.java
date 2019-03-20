package animals;

public class Mouse extends Animal implements Run,Eat{
    @Override
    public void run() {

    }
    @Override
    public void eat(){

    }

    @Override
    public void stop() {
        System.out.println("Mouse stop");
    }
}
