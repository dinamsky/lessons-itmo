package lesson9.collect;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class CollectionExample {
    public static void main(String[] args) throws IOException {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        bookArrayList.add(new Book("book"));
        bookArrayList.add(new Book("cars"));
        bookArrayList.add(new Book("book"));
        bookArrayList.add(2,new Book("alfabet"));
        System.out.println(bookArrayList.size());
        for(Book book: bookArrayList){
            System.out.println(book.getTitle());

        }

        Set<Book> bookSet = new HashSet<>(bookArrayList);
        System.out.println("bookset");
        for (Book book:bookSet){
            System.out.println(book.getTitle());
        }
        LinkedList<Book> bookLinkedList = new LinkedList<>();
        bookLinkedList.add(new Book("book1"));
        bookLinkedList.add(new Book("book2"));
        bookLinkedList.add(new Book("book3"));
        bookLinkedList.add(new Book("book4"));
        for (Book book: bookLinkedList){
            System.out.println(book.getTitle());
        }
        System.out.println("treeSet");
        TreeSet<String> strings = new TreeSet<>();
        strings.add("Hello");
        strings.add("Hi");
        strings.add("Ciao");
        strings.add("Aloha");
        strings.add("Tchus");
        for (String str: strings){
            System.out.println(str);
        }
        TreeSet<Book> bookTreeSet = new TreeSet<>();
        bookTreeSet.add(new Book("funkmachine"));
        bookTreeSet.add(new Book("funkmachines"));

        Book book1 = new Book("Petuh");
        Book book2 = new Book("Petuh2");
        TreeSet<Book> books = new TreeSet();
        books.add(book1);
        books.add(book2);
        for (Book book:books){
            System.out.println(book.getTitle());
        }


        Comparator<User> userComparator = new UserNameComparator()
                .thenComparing(new UserAgeComparator());

        TreeSet<User> userTreeSet = new TreeSet<>(userComparator);
        userTreeSet.add(new User("Oleg",42));
        userTreeSet.add(new User("Andrey",12));
        userTreeSet.add(new User("Boris",34));
        userTreeSet.add(new User("Nikita",23));
        userTreeSet.add(new User("Vassily",4));
        for (User user: userTreeSet){
            System.out.println(user.getName()+" "+user.getAge());
        }

ClassLoader loader = CollectionExample.class.getClassLoader();
        File file = new File(loader.getResource("file.txt").getFile());

        //Читаем строки из файла
        List<String> lines = Files.readAllLines(file.toPath());
        List<String> words = new ArrayList<>();
        for (String line: lines){
            String[] wordSplit = line.toLowerCase()
                    .replaceAll("\\p{Punct}"," ")
                    .trim()
                    .split("\\s");
            for (String s:wordSplit){
                if(s.length()>0)
                words.add(s.trim());
            }
            for (String word:words){
                System.out.println(word);
            }
        }








    }
}
class Book implements Comparable<Book>{
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return title != null ? title.equals(book.title) : book.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
// 0 - объекты равны
    // отрыцательное значение - объект будет стоять до Object o
    // положительное значение - объект будет стоять после Object o
    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.getTitle());
    }
}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }



}

class UserNameComparator implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return  o2.getName().compareTo(o1.getName());
    }
}
class UserAgeComparator implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return  Integer.compare(o1.getAge(),o2.getAge());
    }
}