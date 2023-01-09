package javacode.personalstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uteco {
    static int money;
    static int[] result = new int[9];
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        money = Integer.parseInt(bf.readLine());
    }

    static void findMoney(){
        if(money/50000!=0){
            result[0] = money/50000;
            money %= 50000;
        }
        if(money/10000!=0){
            result[1] = money/10000;
            money %= 10000;
        }
        if(money/5000!=0){
            result[2] = money/5000;
            money %= 5000;
        }
        if(money/1000!=0){
            result[3] = money/1000;
            money %= 1000;
        }
        if(money/500!=0){
            result[4] = money/500;
            money %= 500;
        }
        if(money/100!=0){
            result[5] = money/100;
            money %= 100;
        }
        if(money/50!=0){
            result[6] = money/50;
            money %= 50;
        }
        if(money/10!=0){
            result[7] = money/10;
            money %= 10;
        }
        if(money/1!=0){
            result[8] = money/1;
            money %= 1;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        findMoney();
        for(int i : result){
            System.out.print(i+" ");
        }
    }
}
