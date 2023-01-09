package javacode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15655 {
    private static int n, m;
    private static int[] numbers;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        input();
        run(0, 0);
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        result = new int[m];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
    }

    private static void run(int index, int resultIndex) {
        if (resultIndex == m) {
            printResult();
            return;
        }
        for (int i = index; i < n; i++) {
            result[resultIndex] = numbers[i];
            run(i + 1, resultIndex + 1);
        }
    }

    private static void printResult() {
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
