package lesson10.shop;

import java.util.HashMap;

public class Shop {
    static HashMap<String,User> users = new HashMap<>();
    static HashMap<String,Goods> store = new HashMap<>();
    public void doTranz(User user){
       if(user.getBalance()-user.getCart().getSum()>0){
           
           user.setBalance(user.getBalance()-user.getCart().getSum());
       }

    }

    public static void main(String[] args) {
        User user1 = new User("qw1","111",67890);
        User user2 = new User("qw2","111",890);
        User user3 = new User("qw3","111",67890);
        User user4 = new User("qw4","111",7890);
        User user5 = new User("qw5","111",6890);
        Goods good1= new Goods("porsche",2,10000);
        Goods good2= new Goods("joke",2,1090);
        Goods good3= new Goods("pgh",2,90);
        Goods good4= new Goods("psche",2,500);
        users.put(user1.getLogin(),user1);
        users.put(user2.getLogin(),user2);
        users.put(user3.getLogin(),user3);
        users.put(user4.getLogin(),user4);
        users.put(user5.getLogin(),user5);
        store.put(good1.getTitle(),good1);
        store.put(good2.getTitle(),good2);
        store.put(good3.getTitle(),good3);
        store.put(good4.getTitle(),good4);
        Cart cart = new Cart();
        user1.regCart(cart);
        cart.addGood(good1);




    }

}

