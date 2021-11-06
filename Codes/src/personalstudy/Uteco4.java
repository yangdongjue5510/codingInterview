package personalstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uteco4 {
    static int N, answer;
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
    }

    static int threeSixNine(int num){
        if (num==3 || num==6 || num==9){
            return 1;
        }else return 0;
    }
    static int check(int num){
        int result = 0;
        while(num/10!=0){
            int tmp = num%10;
            result+=threeSixNine(tmp);
            num /=10;
        }
        result+=threeSixNine(num);
        return result;
    }

    public static void main(String[] args) throws IOException {
        input();
        for(int i = 1 ; i <= N ; i++){
            answer += check(i);
        }
        System.out.println(answer);
    }
}
