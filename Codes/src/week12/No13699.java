package week12;

import java.io.*;
import java.util.*;

public class No13699 {
    static int number;
    static long[] dp = new long[36];
    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(bf.readLine());
        dp[0] = 1;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(jumhwa(number));
    }

    static long jumhwa(int until) {
        if (until == 0) {
            return 1;
        }
        for (int i = 1 ;  i <= until ; i++) {
            logic(i);
        }
        return dp[until];
    }

    static void logic(int index) {
        long result = 0;
        for (int i = 0 ; i < index/2 ; i++) {
            result += (2 * dp[i] * dp[index-1-i]);
        }
        if (index % 2 != 0) {
            result += dp[index/2]*dp[index/2];
        }
        dp[index] = result;
    }
}
