package javacode;

import java.io.*;
import java.util.*;

public class No16713 {
    private static int N, Q;
    private static int[] a, s, e, sum;

    public static void main(String[] args) throws IOException {
        input();
//        sum[1] = a[1];
        for (int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] ^ a[i];
        }
        int result = 0;
        for (int i = 0; i < Q; i ++) {
            result ^= (sum[e[i]] ^ sum[s[i] - 1]);
        }

        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        a = new int[N];
        sum = new int[N + 1];
        s = new int[Q];
        e = new int[Q];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(bf.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            e[i] = Integer.parseInt(st.nextToken());
        }
    }
}
