package javacode;

import java.util.*;
import java.io.*;

public class No11055 {
    static int N;
    static int[] numArr, dp;

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        numArr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0 ; i < N ; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void generate(int index) {
        dp[index] = numArr[index];
        for (int i = 0 ; i < index ; i++) {
            if (numArr[i] < numArr[index]) {
                dp[index] = Math.max(dp[index], dp[i] + numArr[index]);
            }
        }
    }

    static long findMax() {
        long max = 0;
        for (int i = 0; i < N ; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0 ; i < N ; i++) {
            generate(i);
        }
        System.out.println(findMax());
    }
}
