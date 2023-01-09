package javacode.personalstudy.구현;

import java.io.*;
import java.util.*;
public class No8979 {
    static int N, K;
    static Nation[] nations;

    static class Nation implements Comparable<Nation>{
        int num, gold, silver, bronze;
        Nation(int num, int gold, int silver, int bronze){
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
        public int compareTo(Nation other){
            if(gold != other.gold) return other.gold-gold;
            if(silver != other.silver) return other.silver-silver;
            return other.bronze-bronze;
        }
    }

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nations = new Nation[N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            nations[i] = new Nation(num, gold, silver, bronze);
        }
        Arrays.sort(nations);
    }

    static int findRank(){
        int rank = 1;
        Nation compareNation = nations[0];
        for(int i = 0 ; i < N ; i++){
            if(nations[i].compareTo(compareNation) != 0){
                rank = i+1;
                compareNation = nations[i];
            }
            if(nations[i].num == K) return rank;
        }
        return rank;
    }

    public static void main(String[] args) throws IOException{
        input();
        System.out.println(findRank());
    }
}
