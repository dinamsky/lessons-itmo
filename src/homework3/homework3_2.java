package homework3;
import java.util.Arrays;
public class homework3_2 {
    public static void main(String[] args) {
        System.out.println("Задача 2 - массив нечетных");
        int a = 20;
        int b = 1;
        int arrLength = a/2;
        int[] arr = new int[arrLength];
        for (int i=0;i<arrLength;i++){
           arr[i] = b;
           b+=2;
        }
        System.out.println("Original "+Arrays.toString(arr));
        int i = 0;
        int j = arr.length - 1;
        int tmp;
        while (j > i) {
            tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
            j--;
            i++;
        }
        System.out.println("Reverse "+Arrays.toString(arr));
    }
}
