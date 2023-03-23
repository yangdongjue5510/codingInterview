package javacode;

import java.io.*;
import java.util.*;

public class No14503 {

    private static int X, Y, direction;
    private static int result = 0;
    private static int[][] map;
    private static int[] dirX = {0, 1, 0, -1};
    private static int[] dirY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        st = new StringTokenizer(bf.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            clean();
            if (canClean()) {
                moveRotate();
            }
            else {
                if (canBack()) {
                    moveBack();
                }
                else break;
            }
        }

        System.out.println(result);
    }

    private static void clean() {
        if (map[X][Y] == 0) {
            result ++;
            map[X][Y] = 2;
        }
    }

    private static boolean canClean() {
        for (int i = 0 ; i < 4; i ++) {
            if (isForwardDirty(i)) return true;
        }
        return false;
    }

    private static boolean isForwardDirty(int dir) {
        int[] next = getForward(dir);
        return map[next[0]][next[1]] == 0;
    }

    private static int[] getForward(int dir) {
        return new int[]{X + dirX[dir], Y + dirY[dir]};
    }

    private static void moveRotate() {
        for (int i = 0; i < 4; i++) {
            rotate();
            if (isForwardDirty(direction)) {
                move();
                return;
            }
        }
    }

    private static void rotate() {
        if (direction == 0) {
            direction =  3;
            return;
        }
        direction --;
    }

    private static void move() {
        int[] next = getForward(direction);
        X = next[0];
        Y = next[1];
    }

    private static boolean canBack() {
        return map[X - dirX[direction]][Y - dirY[direction]] != 1;
    }

    private static void moveBack() {
        X -= dirX[direction];
        Y -= dirY[direction];
    }
}
