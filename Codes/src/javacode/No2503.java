package javacode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2503 {
    private static Queue<String> numbers = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        init();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int trial = Integer.parseInt(bf.readLine());
        for (int i = 0; i < trial; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String input = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            filter(input, strike, ball);
        }
        System.out.println(numbers.size());
    }

    private static void init() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 1; k < 10; k++) {
                    if (k == j || k == i) {
                        continue;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(i).append(j).append(k);
                    numbers.offer(sb.toString());
                }
            }
        }
    }

    private static void filter(String input, int strike, int ball) {
        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            String line = numbers.poll();
            int s = strike;
            int b = ball;
            for (int j = 0; j < 3; j++) {
                if (line.charAt(j) == input.charAt(j)) {
                    s--;
                    continue;
                }
                if (input.contains(String.valueOf(line.charAt(j)))) {
                    b--;
                }
            }
            if (s == 0 && b == 0) {
                numbers.offer(line);
            }
        }
    }
}
