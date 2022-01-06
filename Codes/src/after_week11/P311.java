package after_week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P311 {
	static int N, teamCount;
	static List<Integer> pioneerList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		input();
		findTeamCount();
		System.out.println(teamCount);
	}

	private static void findTeamCount() {
		int pre = pioneerList.get(0);
		int nowCount = 0;
		for (int i = 0; i < N; i++) {
			if (pioneerList.get(i) != pre) {
				teamCount += nowCount / pre;
				nowCount = 0;
				pre = pioneerList.get(i);
			}
			nowCount++;
		}
		teamCount += nowCount / pioneerList.get(pioneerList.size()-1);
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			pioneerList.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(pioneerList, Collections.reverseOrder());
	}
}
