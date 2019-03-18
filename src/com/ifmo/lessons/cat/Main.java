package com.ifmo.lessons.cat;

public class Main {
    public static void main(String[] args) {
        Cat catFirst = new Cat("Pushok",4,5,3);
        Cat catSecond = new Cat("Barsik",3,2,5);
        System.out.println(catFirst + " fights "+ catSecond);
        System.out.println("and the winner is! ---");
        System.out.println(((catFirst.getTotalPower() > catSecond.getTotalPower())? catFirst : catSecond));

    }
}
