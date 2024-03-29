package javacode.personalstudy.완전탐색;
import java.util.*;
import java.io.*;
/*
완전탐색 : N개에서 중복허용해서 M개 고르기
 */
public class No15652 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    static void rec_func(int index){
        if(index == M+1){
            for(int i = 1 ; i < M+1 ; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else{
            int check = (index>1)? arr[index-1] : 1;
            for(int cant = check ; cant <N+1 ; cant++){
                arr[index] = cant;
                rec_func(index+1);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        arr = new int[M+1];
        rec_func(1);
        System.out.println(sb);
    }
}
