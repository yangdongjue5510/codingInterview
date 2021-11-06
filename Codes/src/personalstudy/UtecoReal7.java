package personalstudy;

public class UtecoReal7 {
    import java.util.*;
    class Solution {
        static char[][] gridArr;
        public String[] solution(String[] grid, boolean clockwise) {
            gridArr = new char[grid.length][];
            for(int i = 0 ; i < grid.length ; i++){
                gridArr[i] = grid[i].toCharArray();
            }
            String[] answer = {};
            if(clockwise){
                answer = clockTrue();
            }else{
                answer = clockFalse();
            }

            return answer;
        }


        static String[] clockTrue(){
            List<String> list = new ArrayList<>();
            for(int i = 0 ; i <= (gridArr.length-1)*2 ;i+=2){
                list.add(trueUp(gridArr.length-1, i));
            }
            String[] result = list.toArray(new String[gridArr.length]);
            return result;
        }

        static String trueUp(int x, int y){
            StringBuilder sb = new StringBuilder();
            while(true){
                sb.append(gridArr[x][y]);
                if(y!=0){
                    y-=1;
                    sb.append(gridArr[x][y]);
                    x-=1;
                    y-=1;
                    continue;
                }else break;
            }
            return sb.toString();
        }

        static String[] clockFalse(){
            List<String> list = new ArrayList<>();
            for(int i = gridArr.length-1; i >=0 ; i--){
                list.add(falseDown(i, i*2));
            }
            String[] result = list.toArray(new String[gridArr.length]);
            return result;
        }

        static String falseDown(int x, int y){
            StringBuilder sb = new StringBuilder();
            while(true){
                sb.append(gridArr[x][y]);
                if(x != gridArr.length-1){
                    x+=1;
                    y+=1;
                    sb.append(gridArr[x][y]);
                    y-=1;
                    continue;
                }else break;
            }
            return sb.toString();
        }
    }
}
