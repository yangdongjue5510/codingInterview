import java.io.*;
import java.util.*;

public class No10986 {
    private static long result;
    private static int[] remainderCounts;

    public static void main(String[] args) throws IOException {
        input();
        result += remainderCounts[0];
        for (int count : remainderCounts) {
            result += (long) count * (count -1) / 2;
        }
        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        remainderCounts = new int[m];

        tokenizer = new StringTokenizer(reader.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(tokenizer.nextToken());
            sum %= m;
            remainderCounts[sum] ++;
        }
    }
}
