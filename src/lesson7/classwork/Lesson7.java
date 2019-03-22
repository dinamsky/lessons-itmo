package lesson7.classwork;

public class Lesson7 {
    public static void main(String[] args) {
        int a = 5;
        Integer intVar = 5;
        Byte byteVar;
        Float floatVar;
        Double doubleVar;
        Character character;
        Short shortVar;
        Boolean bool;

        System.out.println(Integer.MAX_VALUE);

        // методы, преобазующтие строку в число
        Byte.parseByte("45"); //byte
        Byte.valueOf("2");//Byte
        System.out.println(Integer.parseInt("23"));//Int
        System.out.println(Integer.valueOf("23"));//Integer
        Integer int1 = 2;
        Integer int2 = 2;
        if (int1==int2){
            System.out.println("int1 == int 2");
        }
        Integer int3 = 200;
        Integer int4 = 200;
        if (int3 == int4){
            System.out.println("int3 == int 4");
        }
        else {
            System.out.println("int3 != int4");
        }


        int3.longValue(); //вернет примитив
        int2.doubleValue(); // вернет примитив



    }
}
