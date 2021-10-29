package week5.queue;
import java.util.*;
import java.io.*;
public class No1927 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0 ; i < N ; i++){
            int x = Integer.parseInt(bf.readLine());
            if (x!=0){ queue.add(x); }
            else{
                if(queue.size()!=0) x = queue.poll();
                System.out.println(x);
            }

        }
    }
}
