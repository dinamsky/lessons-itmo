package springexample;

import entities.Cat;
import entities.Dog;
import entities.Parrot;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("entities");
        Cat cat = context.getBean(Cat.class);
        Dog dog =(Dog) context.getBean("dog");
        Parrot parrot = context.getBean("parrot-kesha",Parrot.class);
        System.out.println(cat.getName());
        System.out.println(dog.getName());
        System.out.println(parrot.getName());
    }
}
