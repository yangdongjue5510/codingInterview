package javacode.after_week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P315 {
	static int N, M;
	static List<Integer> balls = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		input();
		int count = 0;
		for(int i = 0 ; i<balls.size()-1;i++) {
			int j = i+1;
			while(j<balls.size()) {
				if(balls.get(i) != balls.get(j)) {
					count++;
				}
				j++;
			}
		}
		System.out.println(count);
	}

	static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());

		while(st.hasMoreTokens()) {
			balls.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(balls);
	}
}
