package homework5.task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calc calc;
        double x;
        double y;
        int ask = 1;
       do{

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        x = scanner.nextInt();
        System.out.println("Введите число");
        y = scanner.nextInt();
        System.out.println(" + - * / ");
        switch (scanner.next()) {
           case "+":
                calc = new Calc(new Add());
                System.out.println(calc.execute(x, y));
                break;

           case "-":
                calc = new Calc(new Sub());
                System.out.println(calc.execute(x, y));
                break;

           case "*":
                calc = new Calc(new Multiply());
                System.out.println(calc.execute(x,y));
                break;

           case "/":
                calc = new Calc(new Div());
                System.out.println(calc.execute(x,y));
                break;

           default:
                System.out.println("ERROR");
                break;


        }
           System.out.println("Считать еще? Да(1) - Нет(0)");
           ask = scanner.nextInt();


    }
    while(ask == 1);
}}
