package lesson2;

import java.util.Scanner;

public class lesson2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter code!");
        int code = in.nextInt();

        // ветвление

        if (code == 123) {
            System.out.println("OMG - end");
        } else if (code == 173) {
            System.out.println("OMG -not end");
        } else {
            System.out.println("Not true!");
        }

        int a = 5;
        int b = 7;

        if (a == 5) {
            System.out.println("OMG - end");
            if (b == 7) {
                System.out.println("bingo");
            }
        } else if (code == 7) {
            System.out.println("OMG -not end");
        } else {
            System.out.println("Not true!");
        }
        Scanner in2 = new Scanner(System.in);
        System.out.println("Enter yor lucky number");
        int num = in2.nextInt();

        String res;
        switch (num) {
            case 333333:
                res = "You are so fucking lucky";
                break;
            case 33334:
            case 44445:
                res = "You are middle class fucking lucky";
                break;
            case 44435:
            case 33354:
            case 44425:
                res = "You are fuckin beggar lucky";
                break;
            default:
                res = "You are not fucking lucky";


        }
        System.out.println(res);


        //циклы
        int count = 5;
        while (count > 0) {
            System.out.println("Message number" + count);
            count--;


        }

        do {
            System.out.println("First iter");
            count--;
        } while (count > 0);

        // for (иннициализация; поверка условия ; шаг) {тело цикла}

        for (int i = 1; i < 11; i++) {
            if (i % 2 == 0) continue;// при выполнении этого условия цикл начнет выполнение со следуещего шага - for...
            System.out.println("i=" + i);

        }


        for (int j = 1; j < 3; j++) {
            System.out.println("внешний цикл" + j);
            for (int k = 1; k < 15; k++) {
                System.out.println("внутреннийний цикл" + k);
                if (k == 5) break;
            }
        }
        outer:
        for (int j = 1; j < 3; j++) {
            System.out.println("внешний цикл" + j);
            for (int k = 1; k < 15; k++) {
                System.out.println("внутренний цикл" + k);
                if (k == 5) break outer;
            }
        }
    }
}
