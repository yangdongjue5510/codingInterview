package javacode.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dp4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        String[] tokens = line.split(" ");
        int N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < N ; i++) {
            list.add(Integer.parseInt(bf.readLine()));
        }
        int[] dp = new int[M+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (int i : list) {
            for (int j = i ; j < M+1; j++) {
                if (dp[j-i] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j-i]+1);
                }
            }
        }
        int result = dp[M] == 10001 ? -1 : dp[M];
        System.out.println(result);
    }
}
