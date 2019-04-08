package lesson11.exceptions;

import java.util.Arrays;

public class CatchException {
    public static void main(String[] args) throws Exception {
//        //int zero division
//        int a= 9;
//        int b = 0;
//        System.out.println(a/b);// ArithmeticException
//
//        //попытка получить несуществующий элемент массива
        int[] arr = new int[5];
//        arr[10] = 12;
//        System.out.println(Arrays.toString(arr));// ArrayIndexOfBoundsException
//
//        String str = null;
//        str.equals("string");//NullPointerException
//
//        Integer.parseInt("asd"); // NumberFormatException

        //обработка исключений осуществляется при помощи конструкции try catch
        try {
            Object data = "421";
            Integer intData = (Integer) data;//ClassCastException
            System.out.println("после иксцепшн внутри трай");
        } catch (ClassCastException e) {
            System.out.println("classCastException" + e.getMessage());
        }
        Object data = "421";
        try {
            if (System.currentTimeMillis() % 2 == 0) {
                Integer intData = (Integer) data;

            } else {
                arr[25] = 56;
            }
        }
        //     catch (ClassCastException | ArrayIndexOutOfBoundsException e){
        //          System.out.println("ClassCast" + "ArrayIndex" + e.getMessage());
        //     }
        catch (RuntimeException e) {
            System.out.println("RuntimeExcept" + e.getMessage());
            //  e.printStackTrace();
        } finally {
            System.out.println("закрытие resources используемых в блоке try");
        }

//        try {
//            voidWithException();
//        }
//        catch






    }
    public static void voidWithException() throws Exception{
        //обрабатываемые исключения checked
       // if(i<10)
        throw new Exception("Some exception");

    }

}
