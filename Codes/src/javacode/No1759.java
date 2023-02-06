package javacode;

import java.io.*;
import java.util.*;

public class No1759 {
    private static int L, C;
    private static char[] letters;
    private static char[] password;

    public static void main(String[] args) throws IOException {
        input();
        recFunc(0, -1, 0, 0);
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        letters = bf.readLine().replace(" ", "").toCharArray();
        Arrays.sort(letters);
        password = new char[L];
    }

    private static void recFunc(int index, int prev, int vowel, int cons) {
        if (index == L) {
            if (vowel >= 1 && cons >= 2) {
                System.out.println(password);
            }
            return;
        }

        for (int i = prev + 1; i < C; i++) {
            password[index] = letters[i];
            int isVowel = (letters[i] == 'a' || letters[i] == 'e'
                    || letters[i] == 'i' || letters[i] == 'o' || letters[i] == 'u') ? 1 : 0;
            recFunc(index + 1, i, vowel + isVowel, cons + (1 - isVowel));
        }
    }
}
