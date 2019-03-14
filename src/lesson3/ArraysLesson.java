package lesson3;

import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {
        // java.util.Arrays
        // обьявление пееменной массива
        int[] arr; // более препочтительный
        int arr2[];
        // создание массива
        arr = new int[5];
        System.out.println(Arrays.toString(arr));

        char[] chars = new char[30];
        System.out.println(Arrays.toString(chars));


        //null
        //размер массива изменить нельзя
        int arrLength = arr.length;
        System.out.println("Размер массива arr "+ arrLength);

        int[] arr3 = {2,4,6,1,89};
        arr3 = new int[]{2,6};
        //обращение к элементам массива
        System.out.println(arr3[1]);
        int[] arr4 = new int[4];
        for (int i = 0; i < arr4.length; i++) {
            arr4[i] += 4;
        }
            System.out.println(Arrays.toString(arr4));


        // создание ссылки на тот же самый массив
         int[] arr5 = {2,7,9,90,1};
    //     int[] arr6 = arr5;

        // копирование массива

        int[] arr6 = arr5.clone();

        int[] arr7 = new int[10];
        System.arraycopy(arr5, 0, arr7, 2, 2);
        System.out.println(Arrays.toString(arr7));

        int[] arr8 = {2,7,1,90};
        int[] copyArr = Arrays.copyOf(arr8,12);
        System.out.println(Arrays.toString(copyArr));



        //перебор массива
        for (int i = 0; i< arr8.length; i++){
            System.out.println(arr8[i]);
            arr8[i] += 3;

        }
        System.out.println(Arrays.toString(arr8));



        for (int num: arr8){
            System.out.println(num);
                    }
        System.out.println(Arrays.toString(arr8));

        // сравнение массивов

        int[] arr9 = new int[5];
        int[] arr10 = new int[5];

        System.out.println(Arrays.equals(arr9,arr10));

        Arrays.fill(arr9,23);
        //поиск в массиве
        int[] arr11 = {2,4,6,1,89};
        System.out.println(Arrays.binarySearch(arr11,4));// посмотреть бинарный поиск
        //возвращает  -(точка входа)-1


        // содержит лимассив указанный элемент
        String[] srtArr = {"qwe","rty","swq"};
        System.out.println(Arrays.asList(srtArr).contains("qwe"));

        // сортиовка массива
        System.out.println(Arrays.toString(arr11));
        Arrays.sort(arr11);
        System.out.println(Arrays.toString(arr11));



    }




}
