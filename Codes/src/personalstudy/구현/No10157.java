package personalstudy.구현;
import java.io.*;
import java.util.*;

public class No10157 {
    static int map[][];
    static boolean visit[][];
    static int r,c,k;

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int cnt = 1;

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        c= Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        k = Integer.parseInt(bf.readLine());
    }

    public static void main(String[] args) throws IOException{
        input();
        StringBuilder sb = new StringBuilder();
        cnt = 1;
        int x = r-1;
        int y = 0;
        int dir = 0;
        if(r*c < k){
            System.out.println(0);
            return;
        }
        while(cnt !=k){
            map[x][y] = cnt;
            int nx = x+dx[dir];
            int ny = y+dy[dir];

            if(nx<0 || ny<0 || ny>=c || nx>=r || map[nx][ny] != 0){
                dir++;
                if(dir==4)dir=0;
                nx = x+dx[dir];
                ny = y+dy[dir];
            }

            x=nx;
            y=ny;
            cnt++;
        }

        sb.append(y+1).append(" ").append(r-x);
        System.out.println(sb);
    }
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < numbers.length ; i++){
            for(int j = 0 ; j < numbers.length ; j++){
                int num = numbers[i]+numbers[j];
                if(!list.contains(num)){
                    list.add(num);
                }
            }
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}