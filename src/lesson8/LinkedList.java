package lesson8;

public class LinkedList<T> {
    private Node<T> head;

    public void add(T value) {
        if (head == null) {
            head = new Node<T>(value);

            return;
        }

        find(-1).next = new Node<T>(value);
    }

    public T get(int idx) {
        Node<T> res = find(idx);

        return res == null ? null : res.value;
    }

    public T remove(int idx) {
        if (head == null)
            return null;

        if (idx == 0) {
            T val = head.value;

            head = head.next;

            return val;
        }

        Node prev = find(idx - 1);

        if (prev != null) {
            Node<T> cur = prev.next;

            if (cur != null) {
                prev.next = prev.next.next;

                return cur.value;
            }
        }

        return null;
    }

    private Node find(int idx) {
        if (idx == 0)
            return head;

        int cnt = 0;

        Node node = head;

        while (node != null) {
            if (cnt++ == idx)
                return node;

            if (idx < 0 && node.next == null)
                return node;

            node = node.next;
        }

        return null;
    }



}


class Node<T> {
    T value;

    Node next;

    public Node(T value) {
        this.value = value;
    }
}
