package personalstudy;
import java.util.*;
public class UtecoReal6 {
    static int mondayStartMin = stringToTime("1PM")*60;
    static int mondayEndMin = stringToTime("6PM")*60;
    static int fridayStartMin = stringToTime("9AM")*60 + 30;
    static int fridayEndMin = stringToTime("6PM")*60;
    public String solution(double time, String[][] plans) {
        int vacation = (int)(time*60);
        String answer = "";
        for(String[] arr : plans){
            int consumeTime = checkVacation(arr);
            if(vacation-consumeTime<0) break;
            else{
                answer = arr[0];
                vacation -= consumeTime;
            }
        }

        return answer;
    }

    static int stringToTime(String str){
        int tmp = 1;
        if(str.length() == 4) tmp =2;
        String timeStr = str.substring(0,tmp);
        int time = Integer.parseInt(timeStr);
        if(str.charAt(str.length()-2) == 'P') time+=12;
        return time;
    }

    static int checkVacation(String[] arr){
        int startMin = stringToTime(arr[1])*60;
        int endMin = stringToTime(arr[2])*60;
        int fridayVacTime = 0;
        int mondayVacTime = 0;
        if(startMin<fridayStartMin) fridayVacTime = fridayEndMin - fridayStartMin;
        else if(startMin<fridayEndMin) fridayVacTime = fridayEndMin-startMin;
        else fridayVacTime = 0;

        if(endMin>mondayEndMin) mondayVacTime = mondayEndMin-mondayStartMin;
        else if(endMin > mondayStartMin) mondayVacTime = endMin-mondayStartMin;
        else mondayVacTime = 0;

        return fridayVacTime+mondayVacTime;
    }
}

