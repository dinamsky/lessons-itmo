package multithreading.synchronize.text;

import com.sun.source.tree.SynchronizedTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Top100 {
    Map<String,Integer> map;

    public Top100(){

        this.map = map;
    }
    public synchronized void putMap(String s,int a) throws InterruptedException{
              map.put(s,a);
        notify();
    }

//    public synchronized void getMap() throws InterruptedException{
//
//        notify();
//    }
    public static void main(String[] args) throws IOException {

        Top100 top = new Top100();

      
        
        String fileName = "C:\\Users\\Игорь\\IdeaProjects\\lessons\\resources\\wp.txt";
        String str = null;
        try {
            str = Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //    System.out.println(str);
        String str1 = str;
        str = str.toLowerCase();
        str = str.replaceAll("\\W", "");
        System.out.println(str);
        ArrayList list = new ArrayList();
        for(String u: str.split(" ")) {
           list.add(u);

            }
        int i = Runtime.getRuntime().availableProcessors();
        int s = list.size()/i;

for(int a=0;a<i;a++){ Thread thread = new Thread(new MyThread((ArrayList) list.subList(((list.size() * a / i) + 1), list.size() * (a + 1) / i)));
    thread.start();


}
}}
class MyThread implements Runnable{
    ArrayList list;
    int i =0;

    public MyThread(ArrayList list) {
        this.list = list;
    }

    @Override
    public void run() {
        i++;

        System.out.println(i);
        
    }
}
