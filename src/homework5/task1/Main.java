package homework5.task1;

public class Main {
    public static void main(String[] args) {

        NodeList myNodeList = new NodeList();

        myNodeList.add("Jimmy Page");
        myNodeList.add(332);
        myNodeList.add("http://dinamsky.com");
        myNodeList.add("23:46");

        System.out.println(myNodeList);

        System.out.println(myNodeList.get(1));
        myNodeList.remove(1);
        System.out.println(myNodeList);

        System.out.println("");

        NodeList myQueueList = new NodeList();

        myQueueList.enqueue("Angry Birds 247");
        myQueueList.enqueue("Subway Surfers 456");
        myQueueList.enqueue("Лисичанская 14 кв 8 ");
        myQueueList.enqueue("Enter the void");

        System.out.println(myQueueList);
        System.out.println("Выходит первый элемент очереди = " + myQueueList.dequeue());
        System.out.println(myQueueList);

        System.out.println();

        NodeList myStackList = new NodeList();

        myStackList.push("System log 1");
        myStackList.push("System log 5");
        myStackList.push("Error log");
        myStackList.push("Default netconfig 456");

        System.out.println(myStackList);
        System.out.println("Выходит последний элемент стека = " + myStackList.pop());
        System.out.println(myStackList);

    }
}
