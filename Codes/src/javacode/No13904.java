package javacode;

import java.io.*;
import java.util.*;

public class No13904 {
    private static int n, result;
    private static boolean[] hasDate;
    private static PriorityQueue<Task> taskQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < n; i++) {
            Task task = taskQueue.poll();
            final int bestDate = findBestDate(task);
            if (bestDate == -1) {
                continue;
            }
            hasDate[bestDate] = true;
            result += task.score;
        }
        System.out.println(result);
    }
    private static int findBestDate(Task task) {
        for (int i = task.date; i > 0; i--) {
            if (!hasDate[i]) {
                return i;
            }
        }
        return -1;
    }
    private static void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        int biggestDate = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int date = Integer.parseInt(tokenizer.nextToken());
            int score = Integer.parseInt(tokenizer.nextToken());
            taskQueue.add(new Task(date, score));
            if (biggestDate < date) biggestDate = date;
        }
        hasDate = new boolean[biggestDate + 1];
    }

    static class Task implements Comparable<Task> {
        int date, score;
        public Task(int date, int score) {
            this.date = date;
            this.score = score;
        }

        public int compareTo(Task other) {
            return Integer.compare(other.score, this.score);
        }
    }
}
