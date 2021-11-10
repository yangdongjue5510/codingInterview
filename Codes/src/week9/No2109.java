package week9;
import java.io.*;
import java.util.*;
public class No2109 {
    static int N;
    static long result;
    static Univ[] univs;
    static class Univ implements Comparable<Univ>{
        int date, value;
        public Univ(int date , int value){
            this.date = date;
            this.value = value;
        }

        public int compareTo(Univ other){
            if(date == other.date) return other.value - value;
            else return other.date-date;
        }
    }
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        univs = new Univ[N];
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(bf.readLine());
            int value = Integer.parseInt(st.nextToken());
            int date =  Integer.parseInt(st.nextToken());
            univs[i] = new Univ(date, value);
        }
        Arrays.sort(univs);
    }

    static void go(){
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        if(N==0)return;
        for(int i = univs[0].date ; i >0 ; i--){
            while( j<N && univs[j].date==i ){
                que.add(univs[j].value);
                j++;
            }
            if(!que.isEmpty()){
                result+= que.poll();
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        go();
        System.out.println(result);

    }
}