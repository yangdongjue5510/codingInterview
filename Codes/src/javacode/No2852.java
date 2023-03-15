package javacode;

import java.io.*;
import java.util.*;
public class No2852 {
    private static int oneScore, twoScore, oneTime, twoTime, winner;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        int preTime = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int team = Integer.parseInt(st.nextToken());
            int currentTime = getTime(st.nextToken());
            addToWinnerTeam(currentTime - preTime);
            setScore(team);
            if (i == N -1) {
                addToWinnerTeam(getTime("48:00") - currentTime);
            }
            preTime = currentTime;
        }
        System.out.println(timeToString(oneTime));
        System.out.println(timeToString(twoTime));
    }

    private static int getTime(final String line) {
        StringTokenizer st = new StringTokenizer(line, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }

    private static void addToWinnerTeam(final int time) {
        if (winner == 1) oneTime += time;
        if (winner == 2) twoTime += time;
    }

    private static void setScore(int team) {
        if (team == 1) oneScore += 1;
        if (team == 2) twoScore += 1;
        if (oneScore > twoScore) winner = 1;
        if (oneScore < twoScore) winner = 2;
        if (oneScore == twoScore) winner = 0;
    }

    private static String timeToString(int time) {
        String minute = String.format("%02d", time / 60);
        String second = String.format("%02d", time % 60);
        return minute+":"+second;
    }
}
