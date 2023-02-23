package javacode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10448 {

    private static int[] numbers = new int[46];

    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 46; i++) {
            numbers[i] = numbers[i - 1] + i;
        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int trial = Integer.parseInt(bf.readLine());
        for (int i = 0; i < trial; i++) {
            int input = Integer.parseInt(bf.readLine());
            System.out.println(find(input));
        }
    }

    private static int find(int input) {
        for (int j = 1; j < 46; j++) {
            for (int k = 1; k < 46; k++) {
                for (int l = 1; l < 46; l++) {
                    if (numbers[j] + numbers[k] + numbers[l] == input) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
