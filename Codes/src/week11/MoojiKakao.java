package week11;
import java.io.*;
import java.util.*;

public class MoojiKakao {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int tokens = st.countTokens();
        int[] array = new int[tokens];
        for (int i = 0; i < tokens; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(bf.readLine());
        System.out.println(new MoojiKakao().solution(array, k));
    }
    public int solution(int[] food_times, long k) {
        List<Food> foodList = new LinkedList<>();
        long spendTimeSum = 0;
        for (int i = 0 ; i < food_times.length ; i++) {
            spendTimeSum += food_times[i];
            foodList.add(new Food(i+1, food_times[i]));
        }
        if (spendTimeSum <= k) return -1;
        Collections.sort(foodList);
        long removedTime = 0;
        int foodSize = foodList.size();
        while (k >= (foodList.get(0).spendTime - removedTime) * foodSize) {
            Food food = foodList.get(0);
            k -= (food.spendTime - removedTime) * foodSize;
            removedTime = food.spendTime;
            foodList.remove(0);
            foodSize--;
        }

        Collections.sort(foodList, new Comparator<Food>(){
            @Override
            public int compare(Food food1, Food food2) {
                return food1.number - food2.number;
            }
        });

        return foodList.get((int)(k%foodSize)).number;
    }

    static class Food implements Comparable<Food> {
        int number;
        int spendTime;
        public Food(int number, int spendTime) {
            this.number = number;
            this.spendTime = spendTime;
        }

        @Override
        public int compareTo(Food other) {
            return this.spendTime - other.spendTime;
        }
    }
}