package week13;

import java.util.Scanner;

public class Dp1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] array = new int[30001];

        for (int i = 2 ; i < a+1 ; i++) {
            array[i] = array[i-1] + 1;
            if (i % 2 == 0) {
                array[i] = Math.min(array[i] , array[i / 2] + 1);
            }
            if (i % 3 == 0) {
                array[i] = Math.min(array[i], array[i / 3] + 1);
            }
            if (i % 4 == 0) {
                array[i] = Math.min(array[i], array[i / 4] + 1);
            }
            if (i % 5 == 0) {
                array[i] = Math.min(array[i], array[i / 5] + 1);
            }
        }
        System.out.println(array[a]);
    }
}
