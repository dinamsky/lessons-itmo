package multithreading.pool;

import java.util.concurrent.*;

public class FutureTaskExample {
    public static void main(String[] args) {
        Callable<UserInfo> callable1 = new CreateUserTask(2000);
        Callable<UserInfo> callable2 = new CreateUserTask(6000);
        FutureTask<UserInfo> futureTask = new FutureTask<>(callable1);
        FutureTask<UserInfo> futureTask2 = new FutureTask<>(callable2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(futureTask);
        executorService.execute(futureTask2);
        while(true){
            if (futureTask.isDone()&&futureTask2.isDone()){
                System.out.println("all tasks done");
                executorService.shutdown();
                return;
            }
            if (futureTask.isDone()){
                try {
                    System.out.println("futureTask result: " + futureTask.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("waiting futureTask2 to end...");
            while(!futureTask2.isDone()){
                System.out.println(".");
            }
            UserInfo userInfo = null;
            try {
                userInfo = futureTask2.get(200L, TimeUnit.MILLISECONDS);
                if (userInfo!=null){
                    System.out.println(futureTask2.get().getName());

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }

        }
    }
}
class UserInfo{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}

class CreateUserTask implements Callable<UserInfo>{

    long sleepTime;

    public CreateUserTask(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public UserInfo call() throws Exception {
        Thread.sleep(sleepTime);
        UserInfo userInfo = new UserInfo();
        userInfo.setName(Thread.currentThread().getName().toUpperCase());
        return userInfo;
    }
}