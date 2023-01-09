package javacode.personalstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uteco3 {
    static int[] pobi, crong;

    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        pobi = new int[2];
        crong = new int[2];
        pobi[0] = Integer.parseInt(bf.readLine());
        pobi[1] = Integer.parseInt(bf.readLine());
        crong[0]  = Integer.parseInt(bf.readLine());
        crong[1]  = Integer.parseInt(bf.readLine());
    }

    static int pageSum(int left){
        int answer = 0;
        while(left/10!=0){
            answer += left%10;
            left /=10;
        }
        answer+=left;
        return answer;
    }
    static boolean isValid(int a, int b){
        if(a+1 != b) return false;
        if(a>=b) return false;
        if(a<=0 || b<=0) return false;
        if(a==1 || b ==400) return false;
        return true;
    }
    static int pageMulti(int left){
        int answer = 1;
        while(left/10!=0){
            answer *= left%10;
            left /=10;
        }
        answer*=left;
        return answer;
    }

    static int greatNum(int a, int b, int c, int d){
        int max1 =  Math.max(a,b);
        int max2 = Math.max(c,d);
        return Math.max(max1, max2);
    }

    static int battle(int[] arr1, int[] arr2){
        int arr1Score = greatNum(pageMulti(arr1[0]), pageSum(arr1[0]),
                pageMulti(arr1[1]), pageSum(arr1[1]));
        int arr2Score = greatNum(pageMulti(arr2[0]), pageSum(arr2[0]),
                pageMulti(arr2[1]), pageSum(arr2[1]));
        if(isValid(arr1[0], arr1[1]) && isValid(arr2[0],arr2[1])){
            if(arr1Score>arr2Score) return 1;
            if(arr1Score<arr2Score) return 2;
            if(arr1Score==arr2Score) return 0;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        input();

        int result =battle(pobi, crong);
        System.out.println(result);
    }
}
