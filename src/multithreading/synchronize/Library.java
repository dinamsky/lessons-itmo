package multithreading.synchronize;

public class Library {
    public static void main(String[] args) {
        BookStorage storage = new BookStorage();
        new Thread(new PutThread(storage)).start();
        new Thread(new GetThread(storage)).start();
    }
}

class BookStorage{
    int booksCount = 0;
    public synchronized void putBook() throws InterruptedException{
        System.out.println("putBook started");
        while(booksCount>=5){
            wait();
            System.out.println("putBook waiting getBook");
        }
        booksCount++;
        System.out.println("1 taken, books :"+booksCount);
        System.out.println("getBook - ending");
        notify();
    }
    public synchronized void getBook() throws InterruptedException{
        System.out.println("getBook started");
        while(booksCount<=1){
            wait();
            System.out.println("getBook waiting putBook");
        }
        booksCount--;
        System.out.println("1 taken, books :"+booksCount);
        System.out.println("getBook - ending");
notify();
    }

}

class PutThread implements Runnable{
    BookStorage storage;

    public PutThread(BookStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            try {
                storage.putBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class GetThread implements Runnable{
    BookStorage storage;

    public GetThread(BookStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
       for (int i=0;i<100;i++) {
           try {
               storage.getBook();
            } catch (InterruptedException e) {
                e.printStackTrace();

        }}

}}