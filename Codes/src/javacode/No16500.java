package javacode;

import java.io.*;
import java.util.*;

public class No16500 {
    private static boolean[] wordCheck;
    private static List<String> words = new ArrayList<>();
    private static String target;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = target.length()-1; i >= 0; i--) {
            check(i);
        }
        int result = wordCheck[0] ? 1:0;
        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        target = reader.readLine();
        int n = Integer.parseInt(reader.readLine());
        wordCheck = new boolean[target.length() + 1];
        wordCheck[target.length()] = true;
        for (int i = 0; i < n; i++) {
            words.add(reader.readLine());
        }
    }

    private static void check(int index) {
        final String substring = target.substring(index);
        for (String word: words) {
            if (substring.length() < word.length()) continue;
            if (substring.startsWith(word) && wordCheck[index + word.length()]) {
                wordCheck[index] = true;
                return;
            }
        }
    }
}
