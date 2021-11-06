package personalstudy;

public class UtecoReal4 {
    import java.util.*;
    class Solution {
        public static int[] solution(String s) {
            Queue<Character> que = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            char[] charArr = s.toCharArray();
            for(char c : charArr){
                que.add(c);
            }
            if(s.charAt(0)== s.charAt(s.length()-1)){
                char last = s.charAt(s.length()-1);
                while(que.peek()==last){
                    que.add(que.poll());
                }
            }
            while(!que.isEmpty()){
                list.add(countSame(que));
            }
            Collections.sort(list);

            int[] answer = new int[list.size()];
            for(int i = 0 ; i < list.size() ; i++){
                answer[i]  = list.get(i);
            }
            return answer;
        }

        static int countSame(Queue<Character> que){
            int count = 0;
            char tmp = que.peek();
            while(!que.isEmpty()){
                if(tmp == que.peek()){
                    que.poll();
                    count++;
                }else{break;}
            }
            return count;
        }
    }
}
