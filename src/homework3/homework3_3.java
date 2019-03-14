package homework3;

import java.util.Arrays;
import java.util.Random;

public class homework3_3 {
    public static void main(String[] args) {
        System.out.println("Задача 3 Массив случайных элементов - посчитать нечетные");
        int arrLength = 20;
        int a = 0;
        int[] arr = new int[arrLength];
        for (int k = 0; k < arrLength; k++) {

            Random random = new Random();
            int num = 2 + random.nextInt(9-2);
            arr[k] = num;
            if (num%2!=0){
                a += 1;

            }
        }
        System.out.println("Origin "+ Arrays.toString(arr));
        System.out.println("Odds "+a);


    }
}
