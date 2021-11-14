package week9;
import java.io.*;
import java.util.*;

public class No12919 {
    static String startStr, goalStr;
    static int result=0;
    static Queue<String> que = new LinkedList<>();

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        startStr = bf.readLine();
        goalStr = bf.readLine();
    }

    static void bfs(){
        que.add(goalStr);
        while(!que.isEmpty()){
            String str = que.poll();
            if(str.equals(startStr)){
                result = 1;
                System.out.println(result);
                return;
            }
            if(str.length() >=2 && str.charAt(0)=='B'){
                que.add(new StringBuilder(str.substring(1)).reverse().toString());
            }
            if(str.length() >= 2 && str.charAt(str.length()-1)=='A'){
                que.add(str.substring(0,str.length()-1));
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException{
        input();
        bfs();
    }
}
