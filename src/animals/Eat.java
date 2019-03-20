package animals;

public interface Eat {
    public void eat();
    default public void stop(){
        System.out.println("Stop");
    }

}
