package homework3;

import java.util.Scanner;

public class homework3_7 {
    public static void main(String[] args) {
        System.out.println("Задача 7 поиск в строке чисел и запись в числовой массив");
        String stringOrigin = "дом 48, корпус 9, парадная 7, этаж 4";
        char[] num = {0,1,2,3,4,5,6,7,8,9};
        int pos = 0;
        char[] chars = stringOrigin.toCharArray();


        for (int i = 0; i < stringOrigin.length(); i++) {
          for(int k=0;k<10;k++){
              if (chars[i]==num[k]) {


              }
          }
        }


    }

}
