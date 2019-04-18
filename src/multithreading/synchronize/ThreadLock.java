package multithreading.synchronize;

public class ThreadLock {
    public static void main(String[] args) {


    Object obj1 = new Object();
    Object obj2 = new Object();
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("thread1 ST");
                synchronized (obj1){
                    try{
                        Thread.sleep(500);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("thread1 locked");
                    synchronized (obj2){
                        System.out.println("thread2 locked obj1");
                    }
                }


        }
    });

}}
