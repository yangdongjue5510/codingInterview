package personalstudy;

public class UtecoReal5 {
    class Solution {
        static int[][] map;
        static int zero;
        static int rows, columns;

        static class Dto{
            int r, c, writed;
            public Dto(int r, int c, int writed){
                this.r=r;
                this.c=c;
                this.writed =writed;
            }
        }
        public static int[][] solution(int row, int column) {
            rows =row;
            columns = column;
            map = new int[rows+1][columns+1];
            zero = rows*columns;
            map[1][1] = 1;
            int writed = 1;
            int r = 1;
            int c = 1;
            Dto now = new Dto(1,1,1);
            zero --;
            while(zero!=0 && now.writed!=-1){
                if(now.writed%2==0){
                    now = writedHol(now.writed, now.r,now.c);
                }else{
                    now = writedJjack(now.writed, now.r, now.c);
                }
            }
            int[][] answer = new int[rows][columns];
            for(int i = 1 ; i<=map.length-1 ; i++){
                for(int j = 1 ;  j<=map[i].length-1 ; j++){
                    answer[i-1][j-1] = map[i][j];
                }
            }

            return answer;
        }

        static Dto writedHol(int writed, int r, int c){
            if(r+1<=rows){
                r=r+1;
            }else if(r==rows){
                r=1;
            }
            if(map[r][c]!=0 &&map[r][c]%2 != 0) return new Dto(r,c,-1);
            if(map[r][c] == 0) zero--;
            map[r][c] = ++writed;

            return new Dto(r,c,writed);
        }

        static Dto writedJjack(int writed, int r, int c){
            if(c+1<=columns){
                c=c+1;
            }else if(c==columns){
                c=1;
            }
            if(map[r][c]!=0 &&map[r][c]%2 == 0) new Dto(r,c,-1);
            if(map[r][c] == 0) zero--;
            map[r][c] = ++writed;
            return new Dto(r,c,writed);
        }
    }
}
