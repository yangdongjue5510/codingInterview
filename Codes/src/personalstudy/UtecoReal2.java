package personalstudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class UtecoReal2 {

    public String solution(String[] log) {
        int study = 0;
        for(int i = 0 ; i < log.length ; i+=2){
            int start = stringToMin(log[i]);
            int end = stringToMin(log[i+1]);
            study += checkTime(start, end);
        }

        String answer = minToString(study);
        return answer;
    }

    static int checkTime(int start, int end){
        int time = end - start;
        if(time <5) return 0;
        if(time > 105) return 105;
        return time;
    }

    static int stringToMin(String str){
        StringTokenizer st = new StringTokenizer(str, ":");
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        min += (hour*60);
        return min;
    }

    static String minToString(int inputMin){
        StringBuilder sb = new StringBuilder();
        int hour = inputMin/60;
        int min = inputMin%60;
        if(hour/10 == 0) sb.append(0);
        sb.append(hour).append(":");
        if(min/10 == 0) sb.append(0);
        sb.append(min);
        return sb.toString();
    }
}

