package multithreading.pool;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable<Article> articleTread = new TaskThread();
        ArrayList<Future<Article>> list = new ArrayList<>();
        for (int i=0;i<15;i++){
            Future<Article> future = executorService.submit(articleTread);
            list.add(future);
            System.out.println(future.isDone());
            System.out.println(future.isCancelled());
        }
        for (Future<Article> article: list){
            try {
                System.out.println("Article : ->"+article.get().getTitle());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}

class Article{
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                '}';
    }
}

class TaskThread implements Callable<Article>{
    @Override
    public Article call() throws Exception {
        Thread.sleep(1000);
        Article article = new Article();
        article.setTitle(Thread.currentThread().getName());
        return article;
    }
}