package homework5.task1;

public class Main {
    public static void main(String[] args) {

        NodeList myNodeList = new NodeList();

        myNodeList.add(574);
        myNodeList.add(332);
        myNodeList.add(329);
        myNodeList.add(6711);

        System.out.println(myNodeList);

        System.out.println(myNodeList.get(1));
        myNodeList.remove(1);
        System.out.println(myNodeList);

        System.out.println("");

        NodeList myQueueList = new NodeList();

        myQueueList.enqueue(54565);
        myQueueList.enqueue(3432);
        myQueueList.enqueue(2332);
        myQueueList.enqueue(43334);

        System.out.println(myQueueList);
        System.out.println("Выходит первый элемент очереди = " + myQueueList.dequeue());
        System.out.println(myQueueList);

        System.out.println();

        NodeList myStackList = new NodeList();

        myStackList.push(4543);
        myStackList.push(844332);
        myStackList.push(2344);
        myStackList.push(15455);

        System.out.println(myStackList);
        System.out.println("Выходит последний элемент стека = " + myStackList.pop());
        System.out.println(myStackList);

    }
}
