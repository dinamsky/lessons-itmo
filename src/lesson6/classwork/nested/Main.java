package lesson6.classwork.nested;

public class Main {
    public static void main(String[] args) {
        Food apple = new Food.Builder(4)
                .calories(78)
                .fat(76)
                .build();
        System.out.println(apple);

        NodeList list = new NodeList();
        list.add(apple);
        list.add(5);
        list.add(6);


    }
}
