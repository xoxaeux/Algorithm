import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main17143 {
	static class Shark {
		int r, c, s, d, z;
		Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}

	static int R, C, M;
	static Queue<Shark> q = new LinkedList<>();
	static Shark[][] map;
	static int human, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Shark[R][C];

		int r, c, s, d, z;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken()) - 1;
			z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(r, c, s, d, z);
		}

		// execute.
		cnt = 0;
		human = -1; // 초기 사람 위치.
		for (int t = 0; t < C; t++) {
			human++; // 1.사람 이동
			catchShark(); // 2.상어잡기
			moveShark(); // 3.상어이동
		}
		System.out.println(cnt);
	}

	private static void catchShark() {
		for (int i = 0; i < R; i++) {
			// (i,human)에 상어 존재한다면 상어잡기
			if (map[i][human] != null) {
				cnt += map[i][human].z;
				map[i][human] = null;
				return;
			}
		}
	}

	static Shark S;
	static int nr, nc, nd;
	static boolean changeDir;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	private static void moveShark() {
		// 우선 모든 상어들 q에 집어넣기(이동을 위함)
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != null) q.offer(map[i][j]);
			}
		}
		// 맵 초기화
		map = new Shark[R][C];
		while (!q.isEmpty()) {
			// 상어 꺼내서 이동시키기
			S = q.poll();
			nr = S.r + dir[S.d][0] * S.s;
			nc = S.c + dir[S.d][1] * S.s;
			changeDir = false;

			if (nr < 0 || nc < 0) {
				changeDir = !changeDir;
				if (nr < 0)
					nr = -nr;
				if (nc < 0)
					nc = -nc;
			}
			if (nr > R-1) {
				// 벽에 홀수번 닿았을 경우 방향전환.
				if ((nr / (R-1)) % 2 == 1) {
					changeDir = !changeDir;
					nr %= (R-1);
					nr = R-1 -nr;
				}else {
					nr %= (R-1);
				}
			} else if (nc > C-1) {
				if ((nc / (C-1)) % 2 == 1) {
					changeDir = !changeDir;
					nc %= (C-1);
					nc = C-1 -nc;
				}else {
					nc %= (C-1);
				}
				
				
			}
			
			nd = S.d;
			if (changeDir) {
				switch (S.d) {
				case 0:
					nd = 1;
					break;
				case 1:
					nd = 0;
					break;
				case 2:
					nd = 3;
					break;
				case 3:
					nd = 2;
					break;
				}
			}

			if(map[nr][nc]!=null && map[nr][nc].z > S.z) continue;
			map[nr][nc] = new Shark(nr, nc, S.s, nd, S.z);
		}
	}

}
