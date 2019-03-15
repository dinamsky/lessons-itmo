package homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class homework3_7 {
    public static void main(String[] args) {
        System.out.println("Задача 7 поиск в строке чисел и запись в числовой массив");
        String stringOrigin = "дом 48, корпус 9, парадная 7, этаж 4";
//        String stringOrigin = args[0];
        String digitStr = "";
        List<Integer> digits = new ArrayList<Integer>();

        for (int i = 0; i < stringOrigin.length(); i++) {
            if (Character.isDigit(stringOrigin.charAt(i))) {
                digitStr += stringOrigin.charAt(i);
            } else {
                if (!digitStr.isEmpty()) {
                    digits.add(Integer.parseInt(digitStr));
                    digitStr = "";
                }
            }
        }
        if (!digitStr.isEmpty()) {
            digits.add(Integer.parseInt(digitStr));
            digitStr = "";
        }

        for (Integer i : digits) {
            System.out.println(i);
        }

    }

}
