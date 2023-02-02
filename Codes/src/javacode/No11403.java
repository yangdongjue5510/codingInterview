package javacode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11403 {

    private static int[][] graph;
    private static int[][] result;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                visited[j] = false;
            }

            for(int j = 0; j < graph.length; j++) {
                if (graph[i][j] == 1 && !visited[j]) {
                    dfs(i, j);
                }
            }
        }

        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    private static void dfs(int x, int y) {
        visited[y] = true;
        result[x][y] = 1;

        for(int i = 0; i < graph.length; i++) {
            if (graph[y][i] == 1 && !visited[i]) {
                dfs(x, i);
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(reader.readLine());
        graph = new int[nodeCount][nodeCount];
        result = new int[nodeCount][nodeCount];
        visited = new boolean[nodeCount];
        StringTokenizer tokenizer;
        for (int i = 0; i < nodeCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < nodeCount; j++) {
                graph[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }
}
