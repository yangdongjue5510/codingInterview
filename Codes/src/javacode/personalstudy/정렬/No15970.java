package javacode.personalstudy.정렬;

import java.io.*;
import java.util.*;
public class No15970 {
    static int N, result = 0;
    static Dot[] arr;

    static class Dot implements Comparable<Dot>{
        int color, locate;
        public Dot(int locate, int color){
            this.color = color;
            this.locate = locate;
        }
        public int compareTo(Dot other){
            if(color!=other.color) return color- other.color;
            return locate-other.locate;
        }
    }

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new Dot[N];
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(bf.readLine());
            int locate = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            arr[i] = new Dot(locate, color);
        }
        Arrays.sort(arr);
    }

    static void check(){
        for(int i = 0 ; i < N ; i++){
            int preLength=Integer.MAX_VALUE;
            int postLength=Integer.MAX_VALUE;
            if(i!=0 && arr[i-1].color == arr[i].color){
                preLength = arr[i].locate - arr[i-1].locate;
            }
            if(i!=N-1 && arr[i].color == arr[i+1].color){
                postLength = arr[i+1].locate - arr[i].locate;
            }
            if(preLength == Integer.MAX_VALUE && postLength == Integer.MAX_VALUE){
                preLength= 0;
                postLength = 0;
            }
            result+= Math.min(preLength, postLength);
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        check();
        System.out.println(result);
    }
}
