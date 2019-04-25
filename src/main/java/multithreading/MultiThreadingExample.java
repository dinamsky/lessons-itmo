package multithreading;

import static java.lang.System.*;

public class MultiThreadingExample {
   // start() - запускает поток
   public static void main(String[] args) {
       Thread thread = new Thread();
       thread.start();
       Thread myThread = new MyThread();
       myThread.start();
      Thread thread1 = new Thread(new OtherThread("Jkkk"));
      Thread thread2 = new Thread(new OtherThread("dfcxcvd"));
      Thread thread3 = new Thread(new OtherThread("vfggfg"));
      thread1.start();
      thread2.start();
      thread3.start();
 Thread thread5 = new Thread(() -> {
     while(!Thread.currentThread().isInterrupted()){
         out.println("thread5");
         try{
             Thread.sleep(1000);

         }catch (InterruptedException e){
             Thread.currentThread().interrupt();
             e.printStackTrace();
         }
     }

 });
       out.println(thread5.isInterrupted());


       try {
           out.println("waiting");
           thread.join();
           thread1.join();
           thread2.join();
           thread3.join();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       //иннициализация анонимным классом
       Thread thread4 = new Thread(() -> out.println("Running : " + Thread.currentThread().isAlive()));



       out.println("main stop");
   }

}
// создание класса потока
// Thread.currentThread()


class MyThread extends Thread{
    @Override
    public void run() {
        Thread.currentThread().setName("mythread");
        out.println(Thread.currentThread().getName());
    }
}
class OtherThread implements Runnable {
    String name;

    public OtherThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        for (int i = 0; i<3; i++){
            out.println(Thread.currentThread().getName()+i);
        }
    }
}
class WhileThread extends Thread{
    @Override
    public void run() {
        while(true){
            out.println("while thread");
        }
    }
}