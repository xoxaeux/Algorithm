import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4012 {
	static int N;
	static int[][] nums;
	static int[] comb1, comb2;
	static boolean[] selected;
	static int gap, res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			nums = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			selected = new boolean[N];
			comb1 = new int[N / 2];
			comb2 = new int[N / 2];
			res = Integer.MAX_VALUE;

			combination(0, 0);
			System.out.println("#" + tc + " " + res);

		}
	}

	static void combination(int idx, int start) {
		if (idx == N / 2) {
//			comb1에 있는 원소를 제외한 원소들을 comb2로 만들어야함.
			int index = 0;
			for (int i = 0; i < selected.length; i++) {
				if (!selected[i]) {
					comb2[index++] = i;
				}
			}

			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < comb1.length; i++) {
				for (int j = 0; j < comb1.length; j++) {
					if (i != j) {
						sum1 += nums[comb1[i]][comb1[j]];
						sum2 += nums[comb2[i]][comb2[j]];
					}
				}
			}
			gap = Math.abs(sum1 - sum2);
			res = Math.min(gap, res);
			return;
		}
		for (int i = start, end = N; i < end; i++) {
			comb1[idx] = i;
			selected[i] = true;
			combination(idx + 1, i + 1);
			selected[i] = false;
		}

	}

}
