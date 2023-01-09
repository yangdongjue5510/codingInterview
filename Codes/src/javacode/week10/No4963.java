package javacode.week10;
import java.io.*;
import java.util.*;

public class No4963 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] nx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] ny = {0, 1, 1, 1, 0, -1, -1 ,-1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y  = Integer.parseInt(st.nextToken());
            if(x==0 || y==0) break;
            arr = new int[y][x];
            visited = new boolean[y][x];

            for(int i = 0 ; i < y ; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j = 0 ; j<x ; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append(go()).append("\n");
        }
        System.out.println(sb);
    }

    static int go(){
        int a = 0;
        while (true){
            int[] tmp = findFalse();
            if(tmp[0]== -1)break;
            BFS(tmp);
            a++;
        }
        return a;
    }
    static void BFS(int[] p){
        Queue<int[]> que = new LinkedList<>();
        que.add(p);
        int a = p[0];
        int b = p[1];
        visited[a][b] = true;

        while(!que.isEmpty()){
            int[] tmp = que.poll();
            int x = tmp[0];
            int y = tmp[1];
            for(int i = 0 ; i < 8; i++){
                int postX = x+nx[i];
                int postY = y+ny[i];
                if(postX<0 || postY<0 || postX>=arr.length || postY>=arr[0].length
                        || visited[postX][postY]==true || arr[postX][postY] == 0){
                    continue;
                }
                que.add(new int[]{postX, postY});
                visited[postX][postY] = true;
            }
        }
    }

    static int[] findFalse(){
        int[] a= {-1, -1};
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[0].length ; j++){
                if(visited[i][j] == false && arr[i][j] == 1){
                    a = new int[]{i, j};
                }
            }
        }
        return a;
    }
}
