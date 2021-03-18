import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14889 {
	static int N;
	static int[][] map;
	static int[] comb;
	static boolean[] selected;
	static boolean[][] nMap;
	static int cnt1;
	static int cnt2;
	static int sol=Integer.MAX_VALUE;

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
//		조합문제. nCn/2
		comb = new int[N / 2];
		combination(0, 0);
		System.out.println(sol);

	}

	private static void combination(int idx, int start) {
		if (idx == N / 2) {
			selected = new boolean[N];
			nMap = new boolean[N][N];
			cnt1 = 0;
			cnt2 = 0;

			for (int i = 0; i < N / 2; i++) {
				selected[comb[i]] = true;
				for (int j = 0; j < N; j++) {
					if (nMap[comb[i]][j]) {
						cnt1 += map[comb[i]][j];
						cnt1 += map[j][comb[i]];
					}
					nMap[comb[i]][j] = true;
					nMap[j][comb[i]] = true;
				}
			}
//			System.out.println(cnt1);
			nMap = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				if (!selected[i]) {
					for(int j = 0; j < N; j++) {
						if (nMap[i][j]) {
							cnt2 += map[i][j];
							cnt2 += map[j][i];
						}
						nMap[i][j] = true;
						nMap[j][i] = true;
					}
				}
			}
//			System.out.println(cnt2);
			if(sol>Math.abs(cnt1-cnt2)) {
				sol=Math.abs(cnt1-cnt2);
			}
			
			return;
		}
		for (int i = start; i < N; i++) {
			comb[idx] = i;
			combination(idx + 1, i + 1);
		}
	}
}
