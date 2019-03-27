package lesson8;

public class Pair<K, V> {
    K key;
    V value;

    public Pair() {
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

//    public static void main(String[] args) {
//        Pair<Integer,Book> pair = new Pair<>(23,);
//
//
//    }
}
