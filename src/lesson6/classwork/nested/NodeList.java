package lesson6.classwork.nested;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class NodeList implements Stack, Queue, List, Iterable {

    private Node head;
    private int size;


    @Override
    public void add(Object value) {

        if (head == null) {
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;

    }

    @Override
    public Object get(int index) {

        int currentIndex = 0;
        Node temp = head;

        while (temp != null) {
            if (currentIndex == index) {
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void remove(int index) {

        int currentIndex = 0;
        Node temp = head;

        while (temp != null) {
            if (currentIndex + 1 == index) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }


    @Override
    public void enqueue(Object value) {

        if (head == null) {
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    @Override
    public Object dequeue() {

        if (head == null)
            throw new IndexOutOfBoundsException();

        Node temp = head;

        head = temp.getNext();
        size--;

        return temp.getValue();
    }

    @Override
    public void push(Object value) {

        if (head == null) {
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    @Override
    public Object pop() {

        if (head == null)
            throw new IndexOutOfBoundsException();

        Node temp = head;

        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(null);
        size--;

        return temp.getValue();
    }


    @Override
    public String toString() {

        Object[] result = new Object[size];

        int idx = 0;
        Node temp = head;

        while (temp != null) {
            result[idx] = temp.getValue();
            temp = temp.getNext();
            idx++;
        }

        return Arrays.toString(result);
    }
    @Override
    public  Iterator iterator(){
        return new ListIterator(head);
    }

    public class ListIterator implements Iterator{
        Node next;
        public ListIterator(Node node){
            this.next = node;
        }
        @Override
        public boolean hasNext() {
            return next!=null;
        }

        @Override
        public Object next() {
            Object cur = next.value;
            next = next.next;
            return cur;
        }
    }

    private static class Node {

        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}