package week13;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dp2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> bank = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        int[] dp = new int[100];

        dp[0] = bank.get(0);
        dp[1] = Math.max(bank.get(0), bank.get(1));
        for (int i = 2 ; i < n+1 ; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] +bank.get(i));
        }
        System.out.println(dp[n-1]);
    }


}
