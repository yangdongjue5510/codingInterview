package javacode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15656 {
    private static int n, m;
    private static int[] numbers;
    private static int[] result;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        input();
        run(0);
        bw.flush();
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

    private static void run(int resultIndex) throws IOException {
        if (resultIndex == m) {
            printResult();
            return;
        }
        for (int i : numbers) {
            result[resultIndex] = i;
            run(resultIndex + 1);
        }
    }

    private static void printResult() throws IOException {
        for (int i : result) {

            bw.write(i + " ");
        }
        bw.write("\n");
    }
}
