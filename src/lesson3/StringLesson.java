package lesson3;

import java.util.Arrays;

public class StringLesson {
    public static void main(String[] args) {
        String string = "Abrakadabra";
        String string2 = "Abrakadabra";
        String string3 = new String("Abrakadabra");
        string3 = string3.intern();//помещает обьект в пулстрок

        // сравнение строк
        //System.out.println(string == string2); так не надо
        //System.out.println(string == string3);
        System.out.println(string.equals(string3));
        System.out.println(string.equalsIgnoreCase(string3));
        System.out.println(string.startsWith("Ст"));
        System.out.println(string.endsWith("е"));
        //сортировка строк
        String[] strArr = {string,string2,string3};
        Arrays.sort(strArr);

        // конкатенация строк
        String string5 = "Str 1";
        String string6 = "Str 2";
        String string7 = string5 + string6;

        String string8 = "Beginning";
        for (int i = 0; i<3; i++){
            string +="итерация цикла ";
        }
        System.out.println(string8);

       // StringBuilder stringBuilder;
        StringBuffer stringBuffer;

        String string18 = "Beginning";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string18);
        for (int i = 0; i<3; i++){
            stringBuilder.append("iteration ")
            .append(i)
            .append(" ");
        }
        string18 = stringBuilder.toString();
        System.out.println(string18);

//        // методы работы со строками
//        string18.substring(2);// вернет новую строку с 2 индекса
//        System.out.println(string18.substring(2,7));
//        string18.split(""); // разбивает строку на массив по регулярному выражению
//
//        string18.trim(); //убирает пробелы
//        string18.replaceAll("","new str");//замена
//        string18



    }
}
