package javacode.week11;
import java.io.*;
import java.util.*;
public class No19941 {
    static int N, K;
    static char[] line;
    static int result = 0;

    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        line = bf.readLine().toCharArray();
    }

    public static void main(String[] args) throws IOException {
        input();
        execute();
        System.out.println(result);
    }

    static void execute() {
        for (int i = 0 ; i < N ; i++) {
            if (line[i]!='P') {
                continue;
            }
            if (findBurgerLeft(i)) {
                result ++;
            } else if (findBurgerRight(i)) {
                result ++;
            }
        }
    }

    static boolean findBurgerLeft(int i) {
        for (int j = K; j >= 1 ; j--) {
            if (i-j < 0) {
                continue;
            }
            if (line[i-j] == 'H') {
                line[i-j] = 'X';
                return true;
            }
        }
        return false;
    }

    static boolean findBurgerRight(int i) {
        for (int j = 1; j <= K ; j++) {
            if (i+j > N-1) {
                continue;
            }
            if (line[i+j] == 'H') {
                line[i+j] = 'X';
                return true;
            }
        }
        return false;
    }
}
