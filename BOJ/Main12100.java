import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main12100 {

	static int N;
	static int[][] map, nMap;
	static int cnt, maxCnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		nMap = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 상하좌우를 5개 고르는 중복순열.
		permutation(0);
		System.out.println(maxCnt);
	}

	static int[] perm = new int[5];
	static Queue<Integer> q = new LinkedList<>();
	static int past;

	private static void permutation(int idx) {
		if (idx == 5) {
			// map 복사해서 사용하기.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					nMap[i][j] = map[i][j];
				}
			}
			// 이동순서에 맞춰서 숫자 파악하고 집어넣기
			for (int t = 0; t < 5; t++) {
				if (perm[t] == 0) {
					for (int i = 0; i < N; i++) {
						past = -1;
						for (int j = 0; j < N; j++) {
							if (nMap[i][j] == 0)
								continue;
							if (nMap[i][j] == past) {
								q.offer(nMap[i][j] * 2);
								past = -1;
							} else {
								if (past == -1)
									past = nMap[i][j];
								else {
									q.offer(past);
									past = nMap[i][j];
								}
							}
						}
						if (past != -1)
							q.offer(past);
						for (int j = 0; j < N; j++) {
							if (!q.isEmpty())
								nMap[i][j] = q.poll();
							else
								nMap[i][j] = 0;
						}
					}
				} else if (perm[t] == 1) {
					for (int i = 0; i < N; i++) {
						past = -1;
						for (int j = N - 1; j >= 0; j--) {
							if (nMap[i][j] == 0)
								continue;
							if (nMap[i][j] == past) {
								q.offer(nMap[i][j] * 2);
								past = -1;
							} else {
								if (past == -1)
									past = nMap[i][j];
								else {
									q.offer(past);
									past = nMap[i][j];
								}
							}
						}
						if (past != -1)
							q.offer(past);
						for (int j = N - 1; j >= 0; j--) {
							if (!q.isEmpty())
								nMap[i][j] = q.poll();
							else
								nMap[i][j] = 0;
						}
					}
				} else if (perm[t] == 2) {
					for (int j = 0; j < N; j++) {
						past = -1;
						for (int i = N - 1; i >= 0; i--) {
							if (nMap[i][j] == 0)
								continue;
							if (nMap[i][j] == past) {
								q.offer(nMap[i][j] * 2);
								past = -1;
							} else {
								if (past == -1)
									past = nMap[i][j];
								else {
									q.offer(past);
									past = nMap[i][j];
								}
							}
						}
						if (past != -1)
							q.offer(past);
						for (int i = N - 1; i >= 0; i--) {
							if (!q.isEmpty())
								nMap[i][j] = q.poll();
							else
								nMap[i][j] = 0;
						}
					}
				} else if (perm[t] == 3) {
					for (int j = 0; j < N; j++) {
						past = -1;
						for (int i = 0; i < N; i++) {
							if (nMap[i][j] == 0)
								continue;
							if (nMap[i][j] == past) {
								q.offer(nMap[i][j] * 2);
								past = -1;
							} else {
								if (past == -1)
									past = nMap[i][j];
								else {
									q.offer(past);
									past = nMap[i][j];
								}
							}
						}
						if (past != -1)
							q.offer(past);
						for (int i = 0; i < N; i++) {
							if (!q.isEmpty())
								nMap[i][j] = q.poll();
							else
								nMap[i][j] = 0;
						}
					}
				}
			}
			// 2. 가장 큰 수 찾기.
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = Math.max(cnt, nMap[i][j]);
				}
			}
			maxCnt = Math.max(maxCnt, cnt);

			return;
		}

		for (int i = 0; i < 4; i++) {
			perm[idx] = i;
			permutation(idx + 1);
		}
	}
}
