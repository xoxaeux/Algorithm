import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1249 {
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int[][] map,chk;
	static int min;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		String s;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			chk = new int[N][N];
			for(int i=0;i<N;i++) {
				Arrays.fill(chk[i], -1);
			}
			chk[0][0]=0;
			min = -1;

			for (int i = 0; i < N; i++) {
				s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(s.substring(j, j + 1));
				}
			}
			dfs(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}

	static int nx, ny, nextCnt;

	static void dfs(int nowX, int nowY) {
		if (nowX==N-1 && nowY==N-1) {
			min=chk[nowX][nowY];
			return;
		}
		for (int i = 0; i < 4; i++) {
			nx = nowX + dir[i][0];
			ny = nowY + dir[i][1];
			if (nx >= N || nx < 0 || ny >= N || ny < 0)continue;
			nextCnt = chk[nowX][nowY]+map[nx][ny];
			if(min!=-1 && min<nextCnt)continue;
			if(chk[nx][ny]!=-1 && chk[nx][ny]<=nextCnt)continue;
			chk[nx][ny]=nextCnt;
			dfs(nx, ny);
		}
	}
}
