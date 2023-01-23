package javacode;

import java.io.*;
import java.util.*;

public class No5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int trial = Integer.parseInt(reader.readLine());
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < trial; i++) {
            int index = -1;
            for (char letter : reader.readLine().toCharArray()) {
                if (letter == '<') {
                    if (index == -1) continue;
                    index -= 1;
                    continue;
                }
                if (letter == '>') {
                    if (list.size() == 0 || index == list.size() - 1) continue;
                    index += 1;
                    continue;
                }
                if (letter == '-') {
                    if (index == -1) continue;
                    list.remove(index);
                    index -= 1;
                    continue;
                }
                else {
                    index += 1;
                    list.add(index, letter);
                }
            }
            StringBuilder builder = new StringBuilder();
            for (char c : list) {
                builder.append(c);
            }
            System.out.println(builder);
            list.clear();
        }
    }
}
