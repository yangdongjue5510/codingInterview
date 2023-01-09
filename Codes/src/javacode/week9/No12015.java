package javacode.week9;
import java.util.*;
import java.io.*;
public class No12015 {
    static int N, result;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list.add(0);
    }

    static void go(){
        for(int i = 0 ; i < N ; i++){
            int value = list.get(list.size()-1);
            if(arr[i]>value){
                list.add(arr[i]);
            }else{
                int left = 0;
                int right = list.size()-1;
                while(right>left){
                    int mid = (right+left)/2;
                    if(list.get(mid)>=arr[i]){
                        right = mid;
                    }else{
                        left = mid+1;
                    }
                }
                list.set(right, arr[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        go();
        System.out.println(list.size()-1);
    }
}
