package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1661 {
	static int nx, ny, cnt;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static Queue<Integer> q = new LinkedList<>();

	static int nodeX, nodeY;

	public static int bfs(int[][] chk, int[][] map, int x, int y, int endX, int endY) {
		q.add(x);
		q.add(y);
		while (!q.isEmpty()) {
			nodeX = q.remove();
			nodeY = q.remove();
			for (int i = 0; i < 4; i++) {
				nx = nodeX + dx[i];
				ny = nodeY + dy[i];
				if (0 <= nx && nx < map.length && 0 <= ny && ny < map[0].length) {
					if (chk[nx][ny] == 0 && map[nx][ny] == 0) {
						q.add(nx);
						q.add(ny);
						chk[nx][ny]=chk[nodeX][nodeY]+1;
						if(nx==endX && ny==endY) {
							return chk[nx][ny];
						}
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int mapY = Integer.parseInt(st.nextToken());
		int mapX = Integer.parseInt(st.nextToken());
		int[][] map = new int[mapX][mapY];
		int[][] chk = new int[mapX][mapY];
		st = new StringTokenizer(br.readLine());

		int y = Integer.parseInt(st.nextToken()) - 1;
		int x = Integer.parseInt(st.nextToken()) - 1;
		int endY = Integer.parseInt(st.nextToken()) - 1;
		int endX = Integer.parseInt(st.nextToken()) - 1;

		String[] mapIn;
		for (int i = 0; i < mapX; i++) {
			mapIn = br.readLine().split("");
			for (int j = 0; j < mapY; j++) {
				map[i][j] = Integer.parseInt(mapIn[j]);
			}
		}
		System.out.println(bfs(chk, map, x, y, endX, endY));
	}
}
