package homework3;

import java.util.Random;
import java.util.Arrays;
public class Bubblesort {
    public static void main(String[] args) {
    /*Внешний цикл каждый раз сокращает фрагмент массива,
      так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
        int arrLength = 20;
        int[] arr = new int[arrLength];
        for (int k = 0; k < arrLength; k++) {

            Random random = new Random();
            int num = random.nextInt(100);
            arr[k] = num;
        }
        System.out.println("Array Origin  "+Arrays.toString(arr));
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                //Сравниваем элементы попарно,
//              если они имеют неправильный порядок,
//              то меняем местами
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
                System.out.println(j+" sort1 "+Arrays.toString(arr));
            }
            System.out.println(i+" sort2 "+Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }
}
