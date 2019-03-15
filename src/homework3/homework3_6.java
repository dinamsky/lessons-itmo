package homework3;

import java.util.Scanner;

public class homework3_6 {
    public static void main(String[] args) {
        System.out.println("Задача 6 - форматирование строки");
//        Scanner string = new Scanner(System.in);
//        System.out.println("Введите строку");
//        String stringOrigin = string.next();
//        String trimString = stringOrigin.replace();
//        System.out.println(trimString);
        String stringOrigin = "abbbcc hfddeee  ffggghh iijj";
        System.out.println(stringOrigin);
        String trim = stringOrigin.replaceAll("\\s","");
        System.out.println(trim);
        String result = new StringBuilder(stringOrigin).toString();
        result = result.replaceAll("(.)(?=.*\\1)", "");
        result = new StringBuilder(result).toString();
        System.out.println(result);
    }
}

