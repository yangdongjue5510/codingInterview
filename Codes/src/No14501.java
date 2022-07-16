import java.io.*;
import java.util.*;

public class No14501 {
    private static int days, result;
    private static int[] timeSpent;
    private static int[] moneys;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        run();
        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        days = Integer.parseInt(bf.readLine());
        timeSpent = new int[days + 15];
        moneys = new int[days + 15];
        dp = new int[days + 15];
        result = 0;
        StringTokenizer st;
        for (int i = 0; i < days; i++) {
            st = new StringTokenizer(bf.readLine());
            timeSpent[i] = Integer.parseInt(st.nextToken());
            moneys[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void run() {
        for(int i=0; i<=days; i++) {
            dp[i] = Math.max(dp[i],result);

            dp[timeSpent[i]+i] = Math.max(dp[timeSpent[i]+i], moneys[i]+dp[i]);

            result = Math.max(result,dp[i]);
        }
    }
}
