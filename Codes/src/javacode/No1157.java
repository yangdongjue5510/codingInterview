package javacode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No1157 {
    private static final Map<Character, Integer> letterFrequency = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String inputLine = input();
        inputLine = inputLine.toLowerCase();
        initLetterFrequency(inputLine);
        printMostFrequencyLetter();
    }

    private static String input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    private static void initLetterFrequency(String line) {
        char[] letters = line.toCharArray();
        for (char letter : letters) {
            Integer frequency = letterFrequency.get(letter);
            if (frequency != null) {
                letterFrequency.replace(letter, frequency + 1);
                continue;
            }
            letterFrequency.put(letter, 1);
        }
    }

    private static void printMostFrequencyLetter() {
        int maxFrequency = 0;
        for (char letter : letterFrequency.keySet()) {
            int frequency = letterFrequency.get(letter);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        int maxCount = 0;
        char maxLetter = ' ';
        for (char letter : letterFrequency.keySet()) {
            if (letterFrequency.get(letter) == maxFrequency) {
                maxCount++;
                maxLetter = letter;
            }
        }
        if (maxCount >= 2) {
            System.out.println("?");
            return;
        }
        System.out.println(Character.toString(maxLetter).toUpperCase());
    }
}
