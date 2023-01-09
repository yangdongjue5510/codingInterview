package javacode.personalstudy.정렬;

import java.io.*;
import java.util.*;

public class No11652{
    static int N;
    static long[] arr;
    static long result;
    static int maxCount;

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new long[N+1];
        for(int i = 1 ; i < N+1 ; i++){
            arr[i] = Long.parseLong(bf.readLine());
        }
        Arrays.sort(arr);
    }

    static void check(){
        result = arr[1];
        maxCount = 1;
        int nowCount = 1;
        for(int i = 2 ; i < N ; i++){
            if(arr[i]==arr[i-1]){
                nowCount++;
            }
            else{
                nowCount = 1;
            }
            if(maxCount < nowCount){
                result = arr[i];
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        check();
        System.out.println(result);
    }
}
