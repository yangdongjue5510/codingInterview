package javacode.personalstudy.정렬;
import java.io.*;
import java.util.*;

public class No7795 {
    static int testCase, N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < testCase ; i++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N+1];
            B = new int[M+1];
            st = new StringTokenizer(bf.readLine());
            for(int j = 1 ; j < N+1 ; j++){
                A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(bf.readLine());
            for(int j = 1 ; j < M+1 ; j++){
                B[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B, 1, M+1);
            pro();
        }
    }

    static int binarySearch(int x, int L, int R){
        int count = L-1;
        while(R >= L){
            int mid = (R+L)/2;
            if(B[mid] < x){
                count = mid;
                L = mid+1;
            } else{
                R = mid-1;
            }
        }
        return count;
    }

    static void pro(){
        int result = 0;
        for(int i =1 ; i < N+1 ; i++){
            result +=binarySearch(A[i], 1, M);
        }
        System.out.println(result);
    }

}
