package patterns.listener;

import java.util.ArrayList;
import java.util.List;

public class NewsAgensy {
    private List<Listener> listeners = new ArrayList<>();
    public void addListener(Listener listener){
        listeners.add(listener);
    }
    public void remListener(Listener listener){
        listeners.remove(listener);
    }
    public void notifyListeners(String note){
        for(Listener listener:listeners){
            listener.publish(note);
        }
    }
    public void someChanges(String message){
        System.out.println("message -> "+message);
        notifyListeners(message);
    }

    public static void main(String[] args) {
        NewsAgensy agensy = new NewsAgensy();
        agensy.addListener(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("Listener 1:" + str);
            }

        });
        agensy.addListener(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("Listener 2:" + str);
            }

        });
        agensy.someChanges("someChanges");
    }
}

interface Listener {
    void publish(String str);
}