package javacode;

import java.io.*;
import java.util.*;

public class No11722 {
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
        dp[index] = 1;
        for (int i = 0 ; i < index ; i++) {
            if (numArr[i] > numArr[index]) {
                dp[index] = Math.max(dp[index], dp[i] + 1);
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
