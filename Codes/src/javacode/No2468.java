package javacode;

import java.util.*;
import java.io.*;
public class No2468 {
	static int graphSize;
	static int[][] graph;
	static boolean[][] isVisited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0,- 1, 0, 1};
	static int maxHeight = 0;

	public static void main(String[] args) throws IOException {
		input();
		int max = 0;
		for (int i = 0; i <= maxHeight; i++) {
			isVisited = new boolean[graphSize][graphSize];
			int count = 0;
			for(int j = 0; j < graphSize; j++) {
				for(int k = 0; k < graphSize; k++) {
					if(!isVisited[j][k] && graph[j][k] > i) {
						count += dfs(j,k,i);
					}
				}
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
	}

	static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		graphSize = Integer.parseInt(bf.readLine());
		graph = new int[graphSize][graphSize];
		StringTokenizer st;
		for (int i = 0; i < graphSize; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < graphSize; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph[i][j] = num;
				if (maxHeight < num) {
					maxHeight = num;
				}
			}
		}
	}

	static int dfs(int x, int y, int height) {
		isVisited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x +dx[i];
			int ny = y +dy[i];

			if(nx<0 || ny<0 || nx>graphSize-1 || ny >graphSize-1) continue;
			if(isVisited[nx][ny]) continue;
			if(graph[nx][ny]> height) {
				dfs(nx,ny, height);
			}
		}
		return 1;
	}
}
