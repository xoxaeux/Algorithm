package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1681 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int sol = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];
		visited[0] = true;
		dfs(0, 0, 0);

		System.out.println(sol);
	}

//	처음 구해놓고, 백트래킹 사용해야함.
	private static void dfs(int x, int cost, int chk) {
		if (chk == N - 1) {
			if (map[x][0] != 0) {
				cost += map[x][0];
				if (sol > cost) {
					sol = cost;
				}
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i] && cost + map[x][i] < sol && map[x][i] != 0) {
				visited[i] = true;
				dfs(i, cost + map[x][i], chk + 1);
				visited[i] = false;
			}
		}

	}
}
