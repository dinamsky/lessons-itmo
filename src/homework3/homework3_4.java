package homework3;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.random;

public class homework3_4 {
    public static void main(String[] args) {
        System.out.println("Задача 4 сравнение двух половин массива");
        int a;
        int left=0;
        int right=0;
        Scanner num = new Scanner(System.in);
        System.out.println("Введите четное число");
            do{
                a=num.nextInt();
                if(a%2!=0||a<1)System.out.println("Вы ошиблись, введите повторно четное число!");
            }
            while(a%2!=0||a<1);
            int[] arr = new int[a];
            int[] arrLeft = new int[arr.length/2];
            int[] arrRight = new int[arr.length/2];
            int l = 0;
            int r = 0;
            for(int i=0;i<arr.length;i++){
                arr[i]=(int)(random()*11)-5;
                if(i<=arr.length/2-1){
                    arrLeft[l]=arr[i];
                    left+=Math.abs(arr[i]);
                    l++;
                }
                else {
                    arrRight[r]=arr[i];
                    right+=Math.abs(arr[i]);
                    r++;
                }
                if(i==arr.length-1){
                    System.out.println(" ");
                    System.out.println("Origin "+ Arrays.toString(arr));
                    System.out.println("Left "+ Arrays.toString(arrLeft));
                    System.out.println("Right "+ Arrays.toString(arrRight));
                    if(left>right)
                        System.out.println("Первая половина массива больше и равна "+left);
                    if(right>left)
                        System.out.println("Вторая половина массива больше и равна "+right);
                    if(right==left)
                        System.out.println("Первая и вторая половины равны");
                }
            }
        }

    }

