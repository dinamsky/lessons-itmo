package com.ifmo.lessons.homework;

public class Main {
    public static void main(String[] args) {
        List ml = new List();
        ml.addBack(5);
        ml.addBack(3);
        ml.addBack(7);
        ml.addFront(9);

        ml.printList();
        System.out.println();

        ml.delElement (7);
        ml.delElement (4);
        ml.delElement (2);
        ml.delElement (5);

        ml.printList();
        System.out.println();
    }
}
