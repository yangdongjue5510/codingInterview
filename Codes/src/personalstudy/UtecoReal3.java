package personalstudy;

public class UtecoReal3 {
    import java.util.*;
    class Solution {
        static Map<String, Integer> resouce = new HashMap<>();
        static Map<String, Integer> food = new HashMap<>();

        public int solution(String[] ings, String[] menu, String[] sell) {

            resourceToMap(ings);
            foodToMap(menu);
            return calculate(sell);
        }

        static int calculate(String[] sell){
            StringTokenizer st;
            int result = 0;
            for(int i = 0 ; i < sell.length ; i++){
                st = new StringTokenizer(sell[i]);
                String foodName = st.nextToken();
                int count = Integer.parseInt(st.nextToken());
                result += food.get(foodName)*count;
            }
            return  result;
        }
        static int countResource(String str){
            int cost = 0;
            for(int i = 0 ; i<str.length() ; i++){
                String tmp = String.valueOf(str.charAt(i));
                cost += resouce.get(tmp);
            }
            return cost;
        }

        static void foodToMap(String[] arr){
            StringTokenizer st;
            for(int i = 0 ; i < arr.length ; i++){
                st = new StringTokenizer(arr[i]);
                String foodName = st.nextToken();
                int cost = countResource(st.nextToken());
                int sell = Integer.parseInt(st.nextToken());
                food.put(foodName, sell-cost);
            }
        }

        static void resourceToMap(String[] arr){
            StringTokenizer st;
            for(int i = 0 ; i < arr.length ; i++){
                st = new StringTokenizer(arr[i]);
                resouce.put(st.nextToken(), Integer.parseInt(st.nextToken()));
            }
        }
    }
}
