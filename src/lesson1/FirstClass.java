package lesson1;

public class FirstClass {
 //точка входа
    public static void main(String[] args) {
        System.out.println("Some info");

        // примитивные типы
        // byte (1 byte
        // short ( 2 byte
        // int(целые 4 байта
        // long 8 байт
        // float 4 байта
        // double 8 байт
        // char 2 байта
        // boolean(1 байт )
        // обьявление переменной
        // типДанных тияПеременной;
        // типДанных имяПееменной = значение
       // типДанных имяПеременной1, имяПеременной2 итп;
        // целые типы
        byte byteVar;
        short shortVar;
        //short+short=int;

        int a= 1_000_000;
        int b=9;
        int c=5;
        int res = b/c; // остаток отбрасывается в меньшую сторону
        long longVar = 20000000000000L;

        //float
        float floatVar = 2.3F;
        double doubleVar = 2.3;

        // boolean
        boolean isActive = true;
        boolean started =false;

        // автоматическое преобразование
        // приведение типов

        int j = 200;
        long k = j;

        long n = 90;
        int m = (int) n;

        // операторы

        // + - * / %

        // инкремент
        int i = 3;
        i++ ;
        ++i;
        // декремент
        i--;
        --i;

        // сравнение
        // <> == >= <= !=
        // логический операторы
        // &&
        // (a && b) логика и

        //  ||
        //  (a || b) логика или

        // !a не

        // (a^b) строгое или

        //  опеаторы присваивания
        // = += -= *= /= %=
         a=12;
         a +=3; // a = a + 3;

        // тернарный оператор
        //  переменная а = (условие)? выражение1 : выражение2;
        //   (a>b)
        int z=6;
        int x=8;
        int r = (z>x)? z-x:x-z;

// д.з. первого урока
        // 1-параллелепипед
        int a1=5;
        int b1=6;
        int c1=7;
        if (a1>b1) {
            System.out.println("Длина больше");
        }else{
            System.out.println("Ширина больше");

        }
        int s=2*(a1*b1+b1*c1+a1*c1);
        System.out.println("Площадь параллелепипеда");
        System.out.println( s);
        System.out.println("метров");

        //Садовый участок
        int s2 = 1000;
        int a2 = 15;
        int b2 = 25;
        int sOst = s2-(a2*b2);
        System.out.println("Осталось");
        System.out.println( sOst);
        System.out.println("квадратных метров");

        // Овал
        int sОv = 1500 - 600;
        System.out.println("Площадь овала");
        System.out.println(sОv);
        System.out.println("квадратных сантиметров");

        // Модуль
        double n1 = 9.5006;
        double m1 = 10.4995;
        double mMod = Math.abs(m1 - 10);
        double nMod = Math.abs(n1 - 10);
        System.out.println("Ближе к 10 число " + (((nMod == mMod) ? "оба одинаково" : (nMod > mMod)? n1 : m1)));

        // Квадратное уравнение
        double r1,r2;
        double a3 = 1;
        double b3 = 28;
        double c3 = 27;
        double d3 = b3*b3-4*a3*c3;
        if(d3>= 0) {
            r1 = (-b3 + Math.sqrt(d3))/(2*a3);
            r2 = (-b3 - Math.sqrt(d3))/(2*a3);
            System.out.println("Корни уравнения - x1 = "+r1+", x2 = "+r2);
        } else {
            System.out.println("Уравнение не имеет корней");
        }
      // Наибольшая цифра
        int num = 345;
        int num1 = num/100;
        int num2 = (num%100)/10;
        int num3 = num%10;
        if(num1>=num2&&num1>=num3) {
            System.out.println("В числе "+num+" наибольшая цифра "+num1);
        } else if(num2>=num1&&num2>=num3) {
            System.out.println("В числе "+num+" наибольшая цифра  "+num2);
        } else {
            System.out.println("В числе "+num+" наибольшая цифра  "+num3);
        }





        //ссылочные типы

    }
}
