package javacode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15654 {

    static int N, M;
    static int[] numbers;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        run(0);
    }

    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s = bf.readLine();
        st = new StringTokenizer(s);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        result = new int[M];
        visited = new boolean[N + 1];

        String numberLine = bf.readLine();
        st = new StringTokenizer(numberLine);
        for (int i = 0; st.hasMoreTokens(); i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
    }

    static void run(int index) {
        if (index == M) {
            printAll();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[index] = numbers[i];
                run(index + 1);
                visited[i] = false;
            }
        }
    }

    static void printAll() {
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
