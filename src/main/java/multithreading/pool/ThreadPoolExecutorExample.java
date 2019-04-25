package multithreading.pool;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {


        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,
                6,
                2000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(3));
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        linkedBlockingQueue.add(new Task());
        linkedBlockingQueue.add(new Task2());
        linkedBlockingQueue.add(new Task3());
        linkedBlockingQueue.add(new Task());
        linkedBlockingQueue.add(new Task2());
        linkedBlockingQueue.add(new Task3());
        linkedBlockingQueue.add(new Task());
        linkedBlockingQueue.add(new Task2());
        linkedBlockingQueue.add(new Task3());
        for(Runnable runnable:linkedBlockingQueue){
            pool.execute(runnable);
        }

    }
}
class Task implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task : "+ Thread.currentThread().getName());
    }
}
class Task2 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task2 : "+ Thread.currentThread().getName());
    }
}
class Task3 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task3 : "+ Thread.currentThread().getName());
    }
}
