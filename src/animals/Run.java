package animals;

public interface Run extends Runnable, Cloneable {
    default public void stop(){
        System.out.println("Stop");
    }


    public void run();



}
