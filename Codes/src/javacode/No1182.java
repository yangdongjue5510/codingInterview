package javacode;

import java.io.*;
import java.util.*;

public class No1182 {
    private static int n, s, count;
    private static int[] numbers;
    public static void main(String[] args) throws IOException {
        input();
        run(0, 0);
        System.out.println(count);
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void run(int sum, int index) {
        if (index >= n) return;
        if (sum + numbers[index] == s) count ++;
        run(sum, index + 1);
        run(sum + numbers[index], index + 1);
    }
}
