package javacode.personalstudy.구현;
import java.io.*;

public class No1913 {
    static int N, M, P, Q;
    static Slot now;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static class Slot{
        int x, y, num;
        public Slot(int x, int y, int num){
            this.x = x; this.y = y; this.num = num;
        }
    }

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        arr = new int[N+1][N+1];
        now = new Slot(1,1,(int)Math.pow(N,2));
    }
    static void around(){
        if(arr[now.x][now.y] == 0){
            arr[now.x][now.y] = now.num;
            now.num--;
        }
        for(int i =1 ; i <= N ; i++){
            if(now.x+i>N || arr[now.x+i][now.y]!=0 || now.num==0) {
                now.x = now.x+i-1;
                break;
            }
            arr[now.x+i][now.y] = now.num;
            now.num--;
        }for(int i =1 ; i <= N ; i++){
            if(now.y+i>N || arr[now.x][now.y+i]!=0|| now.num==0) {
                now.y = now.y+i-1;
                break;
            }
            arr[now.x][now.y+i] = now.num;
            now.num--;
        }for(int i =1 ; i <= N ; i++){
            if(now.x-i<1 || arr[now.x-i][now.y]!=0|| now.num==0) {
                now.x = now.x-i+1;
                break;
            }
            arr[now.x-i][now.y] = now.num;
            now.num--;
        }for(int i =1 ; i <= N ; i++){
            if(now.y-i<1 || arr[now.x][now.y-i]!=0|| now.num==0) {
                now.y = now.y-i+1;
                break;
            }
            arr[now.x][now.y-i] = now.num;
            now.num--;
        }
    }

    static void findPQ(){
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1; j <= N ; j++){
                sb.append(arr[i][j]).append(" ");
                if(arr[i][j] == M){
                    P = i;
                    Q = j;
                }
            }
            sb.append("\n");
        }
        sb.append(P).append(" ").append(Q);
    }
    static void fill(){

        for(int i = 0 ; i < (N/2)+1 ; i++){
            around();
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        fill();
        findPQ();
        System.out.print(sb);
    }
}
