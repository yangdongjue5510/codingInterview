package week13;

import java.util.Scanner;

public class Dp3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int goal = scanner.nextInt();
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3 ; i < goal+1 ; i++) {
            dp[i] = dp[i-1] + dp[i-2]*2;
        }

        System.out.println(dp[goal]);
    }
}
