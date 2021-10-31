package personalstudy.정렬;

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
        arr = new long[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Long.parseLong(bf.readLine());
        }
        Arrays.sort(arr);
    }

    static void check(){
        long pre = arr[0];
        result = arr[0];
        maxCount = 0;
        int nowCount = 0;
        for(int i = 0 ; i < N ; i++){
            if(maxCount < nowCount){
                maxCount = nowCount;
                result = arr[i-1];
            }
            if(pre == arr[i]){
                nowCount ++;
            }
            if(pre != arr[i]){
                nowCount = 1;
                pre = arr[i];
            }
        }
        if(maxCount < nowCount){
            maxCount = nowCount;
            result = arr[N-1];
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        check();
        System.out.println(result);
    }
}
