package week9;
import java.io.*;
import java.util.*;
public class No1202 {
    static int N, K;
    static int result = 0;
    static List<Integer> bags = new ArrayList<Integer>();
    static Bosuck[] bosucks;

    static class Bosuck implements Comparable<Bosuck>{
        int weight, value;
        public Bosuck(int weight, int value){
            this.weight = weight;
            this.value = value;
        }

        public int compareTo(Bosuck other){
            if(this.weight == other.weight){
                return other.value - this.value;
            }
            return this.weight - other.weight;
        }
    }

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bosucks = new Bosuck[N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(bf.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            bosucks[i] = new Bosuck(weight, value);
        }

        for(int i = 0 ; i < K ; i++){
            bags.add(Integer.parseInt(bf.readLine()));
        }
        Collections.sort(bags);
        Arrays.sort(bosucks);
    }

    static void findBag(){
        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());

        //가방을 하나씩 선택(가벼운 가방먼저)
        for(int i = 0 ; i<bags.size();i++){
            int capacity = bags.get(i);
            int j=0;

            //가방에 담을 수 있는 모든 보석의 가격을 큐에 담음.
            while(j<N && capacity>=bosucks[j].weight){
                que.offer(bosucks[j++].value);
            }
            //담을 수 있는 보석들의 가격중 가장 비싼 것을 큐에서 빼고 결과에 더함.
            if(!que.isEmpty()){
                result+=que.poll();
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        findBag();
        System.out.println(result);
    }
}