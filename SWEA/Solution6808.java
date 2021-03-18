import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution6808 {

	static int[] numsA, numsB;
	static int num, idx;
	static boolean[] chk;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			numsA = new int[st.countTokens()];
			numsB = new int[st.countTokens()];
			chk = new boolean[19];

			for (int i = 0; i < numsA.length; i++) {
				num = Integer.parseInt(st.nextToken());
				numsA[i] = num;
				chk[num] = true;
			}
			idx = 0;
			for (int i = 1; i < chk.length; i++) {
				if (chk[i] == false) {
					numsB[idx++] = i;
				}
			}
			win = 0;
			lose = 0;
			permutation(0);
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}

	static int cnt, scoreA, scoreB, win, lose;
	static boolean[] selected = new boolean[9];
	static int[] selNums = new int[9];

	private static void permutation(int idx) {
		if (idx == 9) {
			scoreA = 0;
			scoreB = 0;
			for (int i = 0; i < 9; i++) {
				if (numsA[i] > numsB[selNums[i]]) {
					scoreA += (numsA[i] + numsB[selNums[i]]);
				} else {
					scoreB += (numsA[i] + numsB[selNums[i]]);
				}
			}
			if (scoreA > scoreB) {
				win++;
			} else if (scoreA < scoreB) {
				lose++;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (selected[i])
				continue;

			selNums[idx] = i;
			selected[i] = true;
			permutation(idx + 1);
			selected[i] = false;
		}
	}
}
