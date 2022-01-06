package after_week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P312 {
	static int result;
	static List<Integer> numList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		input();
		calculate();
		System.out.println(result);
	}

	private static void calculate() {
		result = numList.get(0);
		for (int i = 1; i < numList.size(); i++) {
			result = getCalculated(i, result);
		}
	}

	private static int getCalculated(int index, int sum) {
		if (numList.get(index - 1) == 0 || numList.get(index - 1) == 1
				|| numList.get(index) == 0 || numList.get(index) == 1) {
			return sum + numList.get(index);
		}
		return sum * numList.get(index);
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		numList = Arrays.stream(bf.readLine().split(""))
			.mapToInt(digit -> Integer.parseInt(digit))
			.boxed()
			.collect(Collectors.toList());
	}
}
