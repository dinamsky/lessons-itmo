package homework5.task1;

public class Main {
    public static void main(String[] args) {

        NodeList myNodeList = new NodeList();

        myNodeList.add(4);
        myNodeList.add(2);
        myNodeList.add(9);
        myNodeList.add(11);

        System.out.println(myNodeList);

        System.out.println(myNodeList.get(3));
        myNodeList.remove(1);
        System.out.println(myNodeList);

        System.out.println("");

        NodeList myQueueList = new NodeList();

        myQueueList.enqueue(5);
        myQueueList.enqueue(3);
        myQueueList.enqueue(2);
        myQueueList.enqueue(4);

        System.out.println(myQueueList);
        System.out.println("Выходит первый элемент очереди = " + myQueueList.dequeue());
        System.out.println(myQueueList);

        System.out.println();

        NodeList myStackList = new NodeList();

        myStackList.push(4);
        myStackList.push(8);
        myStackList.push(2);
        myStackList.push(1);

        System.out.println(myStackList);
        System.out.println("Выходит последний элемент стека = " + myStackList.pop());
        System.out.println(myStackList);

    }
}
