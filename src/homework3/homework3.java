package homework3;
import java.util.Arrays;
public class homework3 {
    public static void main(String[] args) {
        System.out.println("Задача 1 - Массив четных");
        int a = 20;
        int b = 2;
        int arrLength = a/2;
        int[] arr = new int[arrLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = b;
            b += 2;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
