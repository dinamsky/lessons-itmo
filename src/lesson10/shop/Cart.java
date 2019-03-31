package lesson10.shop;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Goods> cart = new ArrayList<>();
    public void addGood(Goods goods){
        cart.add(goods);
    }
    public void removeFromeCart(Goods goods){
        cart.remove(goods);
    }
    public double getSum(){
        double summ=0;
        for(Goods goods:cart){
            summ += goods.getPrice();
        }

        return summ;
    }
}
