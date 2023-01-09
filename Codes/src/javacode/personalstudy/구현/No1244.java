package javacode.personalstudy.구현;
import java.io.*;
import java.util.*;

public class No1244 {
    static int bulbCount;
    static int studentCount;
    static int[] bulbs;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bulbCount = Integer.parseInt(bf.readLine());
        bulbs = new int[bulbCount];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < bulbs.length; i++){
            bulbs[i] = Integer.parseInt(st.nextToken());
        }

        studentCount = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < studentCount ; i++){
            st = new StringTokenizer(bf.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            if(gender == 1) boyFunc(index);
            else girlFunc(index-1);
        }
        printBulbs();
    }

    static void printBulbs(){
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i < bulbCount; i++){
            sb.append(bulbs[i]).append(" ");
            if((i+1)%20==0)
                sb.append("\n");
        }
        System.out.print(sb);
    }
    static void boyFunc(int x){
        for(int i = x-1 ; i < bulbCount ; i+=x){
            bulbs[i] = (bulbs[i] == 1)? 0 : 1;
        }
    }

    static void girlFunc(int x){
        int k = 0;
        while(x+k <bulbCount && x-k >= 0){
            if(bulbs[x+k]==bulbs[x-k]){
                bulbs[x+k] = (bulbs[x+k] == 1)? 0 : 1;
                bulbs[x-k] = bulbs[x+k];
            }
            else break;
            k++;
        }
    }
}
