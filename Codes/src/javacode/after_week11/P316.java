package javacode.after_week11;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class P316 {
	static long K;
	static int[] food_times;
	static List<Food> list = new LinkedList<>();

	public long solution(int[] food_times, long k) {
		K = k;
		long sum = 0;
		for (int i = 0; i < food_times.length; i++) {
			list.add(new Food(i + 1, food_times[i]));
			sum += food_times[i];
		}
		if (K >= sum) {
			return -1;
		}
		Collections.sort(list, new Comparator<Food>() {
			@Override
			public int compare(Food o1, Food o2) {
				return o1.time - o2.time;
			}
		});

		eatShortest();
		Collections.sort(list, new Comparator<Food>() {
			@Override
			public int compare(Food o1, Food o2) {
				return o1.index - o2.index;
			}
		});
		return list.get((int)(K % list.size())).index;
	}

	static void eatShortest() {
		long count = 0;
		while (K > (list.get(0).time - count) * list.size()) {
			K -= (list.get(0).time - count) * list.size();
			count = list.get(0).time;
			list.remove(0);
		}
	}

	static class Food {
		int time;
		int index;

		public Food(int index, int time) {
			this.index = index;
			this.time = time;
		}
	}
}
