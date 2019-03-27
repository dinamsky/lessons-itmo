package lesson9.collect;

import java.util.ArrayList;

public class CollectionExample {
    public static void main(String[] args) {
        ArrayList<Book> bookArrayList = new ArrayList<>();
        bookArrayList.add(new Book("book"));
        bookArrayList.add(new Book("cars"));
        bookArrayList.add(new Book("book"));
        bookArrayList.add(2,new Book("alfabet"));
        System.out.println(bookArrayList.size());
        for(Book book: bookArrayList){
            System.out.println(book.getTitle());

        }



    }
}
class Book{
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
}