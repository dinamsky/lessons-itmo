package multithreading.pool;

import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorServices {
    public static void main(String[] args) {
        ExecutorService fixedPool =  Executors.newFixedThreadPool(2);
        fixedPool.execute(new RunnableTask("fixedPool"));
        fixedPool.execute(new RunnableTask("fixedPool2"));
        fixedPool.execute(new RunnableTask("fixedPool3"));
        fixedPool.execute(new RunnableTask("fixedPool4"));
        fixedPool.execute(new RunnableTask("fixedPool5"));
        fixedPool.shutdown();

        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.shutdown();

        ExecutorService cachedThread = Executors.newCachedThreadPool();
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));
        cachedThread.submit(new RunnableTask("cachedThread"));

       ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    }
}
class CallableTask implements Callable<Integer>{
    String name;

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread: "+ name + " = "+(2+3));
        return 2+3;
    }

    public CallableTask(String name) {
        this.name = name;
    }
}
class RunnableTask implements Runnable{
    String name;

    @Override
    public void run() {
        System.out.println("Runnable thread "+ Thread.currentThread().getName()+ name);

    }

    public RunnableTask(String name) {
        this.name = name;
    }
}