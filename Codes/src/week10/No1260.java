package week10;
import java.io.*;
import java.util.*;

public class No1260 {
    static int N, M, V;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i = 0 ; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i = 1 ; i <= N; i++){
            Collections.sort(graph[i]);
        }
    }

    static void BFS(){
        Queue<Integer> que = new LinkedList<>();
        que.add(V);
        visited[V] = true;
        sb.append(V).append(" ");

        while(!que.isEmpty()){
            int tmp = que.poll();

            for(int i : graph[tmp]){
                if(visited[i])continue;
                que.offer(i);
                visited[i] = true;
                sb.append(i).append(" ");
            }
        }
    }

    static void DFS(int x){
        visited[x] = true;
        sb.append(x).append(" ");
        for(int i : graph[x]){
            if(visited[i])continue;
            DFS(i);
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        visited = new boolean[N+1];
        DFS(V);
        sb.append("\n");
        visited = new boolean[N+1];
        BFS();
        System.out.print(sb);
    }
}