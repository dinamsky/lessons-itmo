package lesson8;

public class Main {
    public static void main(String[] args) {
        Book tails = new Book("tails",54);
        Book flowers = new Book("flowers",56);
        Car car = new Car("red");
         LinkedList<Book> bookStorage = new LinkedList();
         bookStorage.add(tails);
         bookStorage.add(flowers);
         LinkedList<Car> carStorage = new LinkedList<>();

         carStorage.add(car);
         Book bookFromBookStorage2 = (Book) bookStorage.get(1);
         Book bookFromBookStorage1 = (Book) bookStorage.get(2);
        Book bookFromBookStorage3 = (Book) bookStorage.get(0);
        LinkedList<ChildBook> childBookStorage = new LinkedList<>();
        ChildBook coloring = new ChildBook("coloring",54);
        childBookStorage.add(coloring);

        Book book = getFirstBook(childBookStorage);




    }
    // со всеми потомками
    public static Book getFirstBook(LinkedList<? extends Book> storage){

        //ChildBook book = new ChildBook("book",12);
        //storage.add(book); так не получится
        return storage.get(0);
    }
    public void addToStorage(LinkedList<? super Book> storage){
        Book book = new Book("book",76);
        storage.add(book);
        //Book book1 = storage.get(0); так не получится
        Object o = storage.get(0);
        System.out.println(o);

    }


    // перегружать методы generic нельзя
    public void someVoid(LinkedList<Integer> storage){};
    public void SomeVoid(LinkedList<String> storage){

    };

    public static void storage(LinkedList<?> storage){
        Book book = new Book("book",54);
        //storage.add(book);//
        storage.add(null);
        //Book book1 = storage.get(0);
        Object o = storage.get(0);
    }

}

