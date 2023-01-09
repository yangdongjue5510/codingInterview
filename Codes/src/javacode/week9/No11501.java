package javacode.week9;
import java.io.*;
import java.util.*;
public class No11501 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());
        for(int j = 0 ; j < testCase ; j++){
            int dayCount = Integer.parseInt(bf.readLine());
            long[] days = new long[dayCount];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i = 0 ; i  < dayCount ; i++){
                long tmp = Long.parseLong(st.nextToken());
                days[i] = tmp;
            }
            long max = 0;
            long result = 0;
            for(int i = dayCount-1 ; i >= 0 ; i--){
                if(max < days[i]) max = days[i];
                else result+=(max-days[i]);
            }
            System.out.println(result);
        }
    }
}
