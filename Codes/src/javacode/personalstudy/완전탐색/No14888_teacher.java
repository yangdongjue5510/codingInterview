package javacode.personalstudy.완전탐색;

import java.io.*;
import java.util.*;

public class No14888_teacher {
    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        No14888.N = Integer.parseInt(bf.readLine());
        No14888.numbers = new int[No14888.N];
        No14888.order = new int[No14888.N-1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < No14888.N ; i++){
            No14888.numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < 4 ; i++){
            No14888.cals[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int calculate(int value, int cal, int nextVal){
        if(cal  == 0) return value+nextVal;
        if(cal == 1) return value-nextVal;
        if(cal == 2) return value*nextVal;
        else return value/nextVal;
    }

    static void rec_func(int index, int num){
        if(index == No14888.N-1) {
            No14888.max = Math.max(No14888.max, num);
            No14888.min = Math.min(No14888.min, num);
        }
        else{
            for(int i = 0 ; i < 4 ; i++){
                if(No14888.cals[i]>=1){
                    No14888.cals[i]--;
                    No14888.order[index] = i;
                    int newValue = calculate(num, i, No14888.numbers[index+1]);
                    rec_func(index+1, newValue);

                    No14888.cals[i]++;
                    No14888.order[index]=0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        rec_func(0, No14888.numbers[0]);
        System.out.println(No14888.max);
        System.out.println(No14888.min);
    }
}
