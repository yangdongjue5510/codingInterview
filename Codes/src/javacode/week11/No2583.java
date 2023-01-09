package javacode.week11;

import java.util.*;
import java.io.*;

public class No2583 {
    static int X, Y, K;
    static boolean[][] graph;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static List<Integer> answer = new ArrayList<>();
    static class Spot {
        int x;
        int y;
        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        graph = new boolean[X][Y];
        K = Integer.parseInt(st.nextToken());
        for (int i = 0 ; i < K; i++ ) {
            st = new StringTokenizer(bf.readLine());
            int y = toInt(st);
            int x = toInt(st);
            int endY = toInt(st);
            int endX = toInt(st);
            checkArea(new Spot(x, y),
                    new Spot(endX, endY));
        }
    }

    public static int toInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0 ; i < X ; i++) {
            for (int j = 0 ; j < Y ; j++) {
                if (!graph[i][j]) {
                    answer.add(bfs(new Spot(i, j)));
                }
            }
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static void checkArea(Spot start, Spot stop) {
        for (int i = start.x; i < stop.x; i++) {
            for (int j = start.y; j < stop.y; j++) {
                graph[i][j] = true;
            }
        }
    }

    static int bfs(Spot start) {
        Queue<Spot> que = new LinkedList<>();
        int size = 0;
        que.add(start);
        graph[start.x][start.y] = true;
        size++;
        while (!que.isEmpty()) {
            Spot out = que.poll();
            for (Spot spot : nearBy(out)) {
                if (spot.x >= X || spot.y >= Y || spot.x < 0 || spot.y < 0
                        || graph[spot.x][spot.y]) {
                    continue;
                }
                que.add(spot);
                graph[spot.x][spot.y] = true;
                size++;
            }
        }
        return size;
    }

    static List<Spot> nearBy(Spot spot) {
        List<Spot> nearSpots = new ArrayList<>();
        for (int i =0 ; i<4; i++) {
            nearSpots.add(new Spot(spot.x+moveX[i], spot.y+moveY[i]));
        }
        return nearSpots;
    }
}
