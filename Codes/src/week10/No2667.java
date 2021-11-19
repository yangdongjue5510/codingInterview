package week10;

import java.util.*;
import java.io.*;

public class No2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] px = {-1, 0, 1, 0};
    static int[] py = {0, 1, 0, -1};
    static ArrayList<Integer> answerList = new ArrayList<>();

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        for(int i = 0 ; i < N; i++){
            String tmp = bf.readLine();
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }
    }

    static int BFS(int[] arr){
        Queue<int[]> que = new LinkedList<>();
        int a = arr[0];
        int b = arr[1];
        que.add(new int[]{a, b});
        visited[a][b] = true;
        int result = 1;

        while(!que.isEmpty()){
            int[] tmp = que.poll();
            int x = tmp[0];
            int y = tmp[1];
            for(int i =0 ; i < 4 ; i++){
                int postX = x+px[i];
                int postY = y+py[i];
                if(postX<0 || postX>=N || postY<0 || postY>=N || map[postX][postY]==0 || visited[postX][postY]==true){
                    continue;
                }
                que.add(new int[]{postX, postY});
                visited[postX][postY] = true;
                result++;
            }
        }
        return result;
    }
    static void go(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0; j < N ; j++){
                if(visited[i][j]==false && map[i][j]==1){
                    answerList.add(BFS(new int[]{i,j}));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        go();
        Collections.sort(answerList);
        System.out.println(answerList.size());
        for(int i : answerList){
            System.out.println(i);
        }
    }
}
