package lesson10;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        HashMap<String, User> userHashMap = new HashMap<>();
        User user1 = new User("qwe","111");
        User user2 = new User("asd","222");
        User user3 = new User("zxc","333");
        User user4 = new User();
        userHashMap.put(user1.getLogin(),user1);
        userHashMap.put(user2.getLogin(),user2);
        userHashMap.put(user3.getLogin(),user3);
        userHashMap.put(null,user4);
        System.out.println(userHashMap.get("asd"));

        for(Map.Entry entry: userHashMap.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
       //LinkedHashList

       //EnumMap
            EnumMap<State,String> enumMap = new EnumMap<State, String>(State.class);
            enumMap.put(State.ERROR,"ERROR");
            enumMap.put(State.STOP,"STOP");
            enumMap.put(State.START,"START");
            System.out.println(enumMap.get(State.ERROR));
            //данные с сортированными ключами
            TreeMap<Integer,String> treeMap = new TreeMap<>();
            treeMap.put(3,"3");
            treeMap.put(6,"2");
            treeMap.put(1,"4");
            treeMap.put(2,"7");
            System.out.println(treeMap);

            Object obj = new Object();
            WeakHashMap<Object,String> weakHashMap = new WeakHashMap<>();
            HashMap<Object,String> hashMap= new HashMap<>();
            Object hashKey = new Object();
            String hashValue = "hashValue";
            Object weakKey = new Object();
            String weakValue = "weakValue";
            hashMap.put(hashKey, hashValue);
            weakHashMap.put(weakKey, weakValue);
            hashKey = null;
            weakKey = null;
            System.gc();
            System.out.println("hashmap"+hashMap);
            System.out.println("weakhash"+weakHashMap);
            // ключи сравниваются с помощью опеации == а не метода equals
           // IdentityHashMap<>
            HashMap<String,Integer> map = new HashMap<>();
            map.put("qwe",23);
            map.put("ase",1);
            map.put("qde",22);
            map.put("qae",26);
            map.put("qfe",15);
            map.remove("qwe");
          //  for (Map.Entry<String,Integer>, Integer)

            Iterator<Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,Integer> entry1 = iterator.next();
                String key = entry1.getKey();
                int val = entry1.getValue();
                if(val<20){
                    iterator.remove();
                }

            }














        }







    }
}
enum State{
    START, STOP, ERROR,
}

class User{
    String login;
    String pwd;

    public User(){}

    public User(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return pwd != null ? pwd.equals(user.pwd) : user.pwd == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }
}