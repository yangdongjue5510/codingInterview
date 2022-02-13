import java.io.*;
import java.util.*;

public class No11660 {
    static int N, M;
    static int[][] map;
    static long[][] dp;
    static int[][] areas;

    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        dp = new long[N+1][N+1];
        areas = new int[M][4];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1 ;  j <= N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0 ; j < 4 ; j++) {
                areas[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void fillDp() {
        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }
    }

    static long findValue(int[] area) {
        int x1 = area[0];
        int y1 = area[1];
        int x2 = area[2];
        int y2 = area[3];
        return dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
    }

    public static void main(String[] args) throws IOException {
        input();
        fillDp();
        for (int[] area : areas) {
            System.out.println(findValue(area));
        }
    }
}
