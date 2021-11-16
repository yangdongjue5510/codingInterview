package week10;
import java.io.*;
import java.util.*;

public class No2178 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        input();
        System.out.println(bfs());
    }
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            String str = bf.readLine();
            for(int j = 0 ; j < M ; j++){
                char tmp = str.charAt(j);
                map[i][j] = Character.getNumericValue(tmp);
            }
        }
    }

    static int bfs() {
        int[] dn = {-1, 0, 1, 0};
        int[] dm = {0, 1, 0, -1};

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0});
        int checked = 1;
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int n = tmp[0];
            int m = tmp[1];

            for(int i = 0 ; i < 4 ; i++){
                int postN = n+dn[i];
                int postM = m+dm[i];
                if(postN>=N || postN<0 || postM >= M || postM<0){
                    continue;
                }
                if(map[postN][postM]==0){
                    continue;
                }
                if(map[postN][postM]==1){
                    map[postN][postM] = map[n][m]+1;
                    que.offer(new int[]{postN, postM});
                }
            }
        }
        return map[N-1][M-1];
    }
}