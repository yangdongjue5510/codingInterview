package javacode;

import java.io.*;

public class No2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 1; i < n; i++) {
            if (sum(i)+i == n) {
                System.out.println(i);
                break;
            }
        }
    }

    private static int sum(int num) {
        int result = 0;
        int digit = 1;
        while (Integer.toString(num).length() >= digit) {
            result += (num % Math.pow(10, digit))/Math.pow(10, digit - 1);
            digit ++;
        }
        return result;
    }
}
