import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main17070 {
	static int[][] map;
	static int cnt=0;
	static int N;

	static class pipe {
		int x1, y1, x2, y2;

		public pipe(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		public int pos() {
			if (Math.abs(y1 - y2) == 1) {
				if (Math.abs(x1 - x2) == 1) {
					return 2; // 대각선
				}
				return 0; // 가로
			}
			return 1; // 세로
		}
	}

	public static void main(String[] args) throws Exception {
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
		if(map[N-1][N-1]==1) {
			System.out.println(0);
			return;
		}
		bfs();
		System.out.println(cnt);
	}

	private static void bfs() {
		Queue<pipe> q = new LinkedList<>();
		q.offer(new pipe(0, 0, 0, 1));
		int x, y;
		pipe p;
		while (!q.isEmpty()) {
			p = q.poll();
			x = p.x2;
			y = p.y2;
			if (x == N - 1 && y == N - 1) {
				cnt++;
				continue;
			}
			switch (p.pos()) {
			case 0: // 가로
				if (y < N - 1 && map[x][y + 1] == 0) {
					q.offer(new pipe(x, y, x, y + 1));
					if (x < N - 1 && map[x + 1][y + 1] == 0 && map[x + 1][y] == 0) {
						q.offer(new pipe(x, y, x + 1, y + 1));
					}
				}
				break;

			case 1: // 세로
				if (x < N - 1 && map[x + 1][y] == 0) {
					if(x==4 && y==5) {
					}
					q.offer(new pipe(x, y, x + 1, y));
					if (y < N - 1 && map[x + 1][y + 1] == 0 && map[x][y + 1] == 0) {
						q.offer(new pipe(x, y, x + 1, y + 1));
					}
				}
				break;
			case 2: // 대각선
				if (y < N - 1 && map[x][y + 1] == 0) {
					q.offer(new pipe(x, y, x, y + 1));
				}
				if (x < N - 1 && map[x + 1][y] == 0) {
					q.offer(new pipe(x, y, x + 1, y));
				}
				if (y < N - 1 && x < N - 1 && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
					q.offer(new pipe(x, y, x + 1, y + 1));
				}
				break;
			}
		}

	}
}
