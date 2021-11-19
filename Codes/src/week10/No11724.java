package week10;
import java.util.*;
import java.io.*;

public class No11724 {
    static int N, E;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        visited[0] = true;
        list = new ArrayList[N+1];
        for(int i = 0 ; i < N+1 ; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(bf.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
    }
    static int findFalse(){
        int a = 0;
        for(int i = 1 ; i <= N ; i++){
            if(!visited[i])
                a = i;
        }
        return a;
    }

    static void BFS(int x){
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        visited[x]= true;

        while(!que.isEmpty()){
            int tmp = que.poll();
            for(int i : list[tmp]){
                if(visited[i]) continue;
                que.add(i);
                visited[i] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        int result = 0;
        while(findFalse()!=0){
            int x = findFalse();
            BFS(x);
            result++;
        }
        System.out.println(result);
    }
}