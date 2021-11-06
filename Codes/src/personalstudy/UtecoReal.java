package personalstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UtecoReal {
    class Solution {
        public int[] solution(int[] arr) {
            int one = 0;
            int two = 0;
            int three = 0;
            for(int i : arr){
                if(i == 1) one++;
                else if(i == 2) two++;
                else if(i ==3) three++;
            }

            int max = Math.max(Math.max(one, two), three);
            int[] answer = {max-one, max-two, max-three};
            return answer;
        }
    }
}
