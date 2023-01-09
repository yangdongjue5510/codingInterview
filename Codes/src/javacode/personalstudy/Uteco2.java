package javacode.personalstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uteco2 {
    static String inputStr;
    static StringBuilder sb =new StringBuilder();
    static String[] aToM = {"A", "B", "C", "D", "E", "F","G","H", "I", "J", "K", "L", "M"};
    static String[] nToZ = {"Z", "Y","X","W","V","U","T","S","R","Q","P","O","N"};

    static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        inputStr = bf.readLine();
    }

    static void changeString(String str){
        if(str.equals(" ")) {
            sb.append(" ");
            return;
        }
        boolean isLower = false;
        if(str.charAt(0)>'Z') {
            str = str.toUpperCase();
            isLower = true;
        }

        if(str.charAt(0)>'M'){
            for(int i = 0 ; i < nToZ.length ; i++){
                if(str.equals(nToZ[i])){
                    String outputStr = (isLower) ? aToM[i].toLowerCase() :aToM[i];
                    sb.append(outputStr);
                    break;
                }
            }
        }
        else if(str.charAt(0)<'N'){
            for(int i = 0 ; i < aToM.length ; i++){
                if(str.equals(aToM[i])){
                    String outputStr = (isLower) ? nToZ[i].toLowerCase() :nToZ[i];
                    sb.append(outputStr);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        for(int i = 0 ; i < inputStr.length() ; i++){
            char chr = inputStr.charAt(i);
            String str = String.valueOf(chr);
            changeString(str);
        }
        System.out.println(sb);
    }
}
