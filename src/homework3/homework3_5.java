package homework3;

import java.util.Scanner;

public class homework3_5 {
    public static void main(String[] args) {
        System.out.println("Задача 5 - поиск и замена строки");
        Scanner string = new Scanner(System.in);
        System.out.println("Введите строку");
        String stringOrigin = string.next();
        Scanner string1 = new Scanner(System.in);
        System.out.println("Введите строку для поиска");
        String stringSearch = string1.next();
        Scanner string2 = new Scanner(System.in);
        System.out.println("Введите строку для замены");
        String stringChange = string2.next();
        String newString = stringOrigin.replace(stringSearch,stringChange);
        System.out.println(newString);



    }
}
