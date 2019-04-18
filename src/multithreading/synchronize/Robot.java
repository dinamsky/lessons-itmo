package multithreading.synchronize;

public class Robot {
   volatile boolean current = true;
    void start(){
new Thread(left).start();
new Thread(right).start();
    }
    Leg left = new Leg("left",true);
    Leg right = new Leg("right", false);

    class Leg implements Runnable{
        String name;
        boolean leg;


        public Leg(String name, boolean leg) {
            this.name = name;
            this.leg =leg;
        }

        @Override
        public void run() {
            while (true){
                if(leg==current){
                    step();
                    Thread.yield();
                    current = !leg;

                }
            }

        }
        void step(){
            System.out.println(name);
        }


    }
    public static void main(String[] args) {
Robot robot = new Robot();
robot.start();
    }
}





