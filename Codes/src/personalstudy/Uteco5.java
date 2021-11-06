package personalstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uteco5 {
    static String inputStr;
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        inputStr = bf.readLine();
    }
    static String decodeString(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length() ; i++){
            if(str.length()-1 == i){
                sb.append(str.charAt(i));
            }
            else if(str.charAt(i)==str.charAt(i+1)) {
                i+=1;
                continue;
            }
            else sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        input();
        String str = inputStr;
//        str= decodeString(inputStr);
        while(true){
            String decode = decodeString(str);
            if(decode.equals(str)){
                break;
            }
            str = decode;
        }

        System.out.println(str);
    }
}
