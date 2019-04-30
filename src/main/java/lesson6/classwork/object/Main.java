package lesson6.classwork.object;

import lesson6.classwork.object.Author;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Object object = new Object();
        Author author = new Author("Leo Tolsty");
        Message message = new Message();
        message.setMessageText("Joker man");

       //toString() - строковое представление объекта
        System.out.println(author.toString()+message.toString());
        // hashcode(int) - возвращает хэшкод объекта - исходный адрес объекта в памяти
        //
        System.out.println(author.hashCode());
        System.out.println(message.hashCode());
        // -XX:hashCode=2 длявыбора реализации  hashCode
        // -XX:UnlockExperimentalVMOptions ключение экспериментальных опций

        // equals (Object o) метод сравнения объектов (true / false)

        Message message1 = new Message();
        message1.setMessageText("messagetext");
        message1.setAuthor(author);
        Message message2 = new Message();
        message2.setMessageText("text");
        message2.setAuthor(author);
        System.out.println(message1.equals(message2));

        // метод clone() позволяет создать копию объекта
        Message message3 =(Message) message1.clone();
        System.out.println(message3.toString());





    }
}
