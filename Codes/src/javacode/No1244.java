package javacode;
import java.io.*;
import java.util.*;

public class No1244 {
    private static int[] switches;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        switches = new int[N+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            execute(gender, index);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<=N; i++) {
            sb.append(switches[i]).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void execute(int gender, int index) {
        if (gender == 1) doMan(index);
        else doWoman(index);
    }

    private static void doMan(int index) {
        int tmp = index;
        while (tmp <= N) {
            change(tmp);
            tmp += index;
        }
    }

    private static void doWoman(int index) {
        change(index);
        int right = index +1;
        int left = index - 1;
        while (right <= N && left >=1) {
            if (switches[right]!= switches[left]) break;
            change(right);
            change(left);
            right += 1;
            left -= 1;
        }
    }

    private static void change(int index) {
        int now = switches[index];
        if (now == 0) switches[index] = 1;
        else switches[index] = 0;
    }
}
