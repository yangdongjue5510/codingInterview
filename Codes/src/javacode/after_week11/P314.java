package javacode.after_week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P314 {
	static int N;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		input();
		int target = 1;
		for (int number : numbers) {
			if (target < number) {
				break;
			}
			target += number;
		}
		System.out.println(target);
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
	}
}
