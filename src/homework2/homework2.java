package homework2;
import java.util.Scanner;
public class homework2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Задача 1 - Убывающая последовательность");
        System.out.println("ВВедите первое число ");
        int a = in.nextInt();
        System.out.println("ВВедите второе число ");
        int b = in.nextInt();
        System.out.println("ВВедите второе число ");
        int c = in.nextInt();


        if (a > b && a > c) {
            System.out.println(a);
            if (b > c) {
                System.out.println(b);
                System.out.println(c);
            } else {
                System.out.println(c);
                System.out.println(b);
                ;
            }
        }
        if (b > a && b > c) {
            System.out.println(b);
            if (a > c) {
                System.out.println(a);
                System.out.println(c);
            } else {
                System.out.println(c);
                System.out.println(a);
            }
        }
        if (c > a && c > b) {
            System.out.println(c);
            if (b > a) {
                System.out.println(b);
                System.out.println(a);
            } else {
                System.out.println(a);
                System.out.println(b);
            }
        }

        System.out.println("задача 2 - последовательность с шагом 5");

        for (int d = 90; d > 0; d--) {
            int e = d % 5;
            if (e == 0) {
                System.out.println(d);
            }
        }
        System.out.println("Задача 3 Последовательность 20 элементов");

        for (int f = 1; f < 21; f++) {
            System.out.println(f + " number " + (int) Math.pow(2, f));
        }
        System.out.println("Задача 4 Проверка натурального числа на простоту)");
        Scanner in2 = new Scanner(System.in);
        System.out.println("Введите число - проверим простое ли оно!");
        int n = in2.nextInt();
        for (int g = 2; g < n; g++){
            int r = n%g;
            if (r!=0){
                System.out.println("Число "+n+" не является простым" );
                break;
            }
        }
        System.out.println("Задача 5 Числа Фибоначчи");
        int j=1;
        int k=1;
        System.out.println(j);
        System.out.println(k);
        for (int s=1;s<12;s++){
            k = k+j;
            System.out.println(k);
            j = k+j;
            System.out.println(j);
        }

        System.out.println("Задача 6 Счастливый билет");
        int m=1;
        for(int i=1;i<1000000;i++){
            int i1=i/100000%10;
            int i2=i/10000%10;
            int i3=i/1000%10;
            int i4=i/100%10;
            int i5=i/10%10;
            int i6=i%10;
            if((i1+i2+i3)==(i4+i5+i6)){
               // System.out.println("Ура - Счастливый билет " + i);
                m++;
            }
        }
        System.out.println("Число счастливых билетов равно = " + m);

        System.out.println("Задача 7 счастливые часы");
        int l=0;
        for(int h=0;h<=23;h++){
            for(int min=0;min<=59;min++){
                if(h/10%10==min%10&h%10==min/10%10){
                    System.out.println("Счастливый момент - время " + h +":" + min);
                    b++;
                }
            }
        }
        System.out.println("Всего "+b+" совпадений");

        System.out.println("Задача 8 таблички");
        int tab=0;
        for(int tabNum=0;tabNum<=50000;tabNum++){
           if ((tabNum/10000%10==2) ^(tabNum/1000%10==2)^(tabNum/100%10 ==2)^(tabNum/10%10==2)^(tabNum%10==2)){
             tab++;
               System.out.println("Надо переделать табличку номер  "+ tabNum);
           }

        }
        System.out.println("Всего "+tab+" табличек переделать");
        System.out.println("Задача 9 Счастливая бронетехника");
        int tech=1;
        for(int i=1;i<100000;i++){
            int i1=i/10000%10;
            int i2=i/1000%10;
            int i3=i/100%10;
            int i4=i/10%10;
            int i5=i%10;
            if (i1 == 4 || i2 == 4 || i3 == 4 || i4 == 4 || i5 == 4){
                //System.out.println("Нeсчастливый танк бортовой номер " + i);
                tech++;}
            if (i1 == 1 && i2 == 3 || i2 == 1 && i3 == 3 || i3 == 1 && i4 == 3 || i4 == 1 && i5 == 3)
            { //System.out.println("Нeсчастливый танк бортовой номер " + i);
                tech++;}
            }

        System.out.println("Число несчастливых танков равно = " + tech);


    }
}







