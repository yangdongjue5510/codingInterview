import java.io.*;
import java.util.*;

public class No2309 {
    private static int[] candidates = new int[9];
    private static int sum = 0;
    public static void main(String[] args) throws IOException {
        input();
        run();
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0 ; i < 9 ; i++) {
            candidates[i] = Integer.parseInt(bf.readLine());
            sum += candidates[i];
        }
    }

    private static void run() {
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - candidates[i] - candidates[j] == 100) {
                    candidates[i] = 0;
                    candidates[j] = 0;
                    Arrays.sort(candidates);
                    for (int k = 2; k < 9; k++) {
                        System.out.println(candidates[k]);
                    }
                    return;
                }
            }
        }
    }
}
