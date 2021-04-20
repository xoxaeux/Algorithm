import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main16637 {
	static int N;
	static long maxNum = Integer.MIN_VALUE;
	static int[] nums;
	static String[] opers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		nums = new int[N / 2 + 1];
		opers = new String[N / 2];

//		입력받기.
		String[] strIn = br.readLine().split("");
		for (int i = 0; i < N / 2; i++) {
			nums[i] = Integer.parseInt(strIn[2 * i]);
			opers[i] = strIn[2 * i + 1];
		}
		nums[N / 2] = Integer.parseInt(strIn[N - 1]);

//		괄호 중복 허용하지 않음. = 전에 것 뽑았으면 안됨.
		for (int i = 0; i < opers.length; i++) {
			chk = new boolean[opers.length];
			combination(opers.length, i, 0, 0);
		}
		if(N==1) {
			System.out.println(nums[0]);
			return;
		}
		System.out.println(maxNum);
	}

	static long resNum;
	static boolean[] chk;

	private static void combination(int n, int r, int idx, int start) {
		if (idx == r) {
			resNum = nums[0];
			int i = 0;
			while (i < opers.length) {
				if (i < opers.length - 1 && chk[i + 1]) { // 다음수와 계산하므로 다음수가 true인지 봐야함.
					calcul(i, true);
					i += 2;
				} else {
					calcul(i, false);
					i++;
				}
			}

			if (resNum > maxNum) {
				maxNum = resNum;
			}
			return;
		}
		for (int i = start; i < n; i++) {
			if (0 < i && chk[i - 1])
				continue;
			if (!chk[i]) {
				chk[i] = true;
				combination(n, r, idx + 1, i + 1);
				chk[i] = false;
			}
		}
	}

	static int partNum;

	private static void calcul(int i, boolean tf) {
		partNum = 999;
		if (tf) {// i+1이 true인 경우
			if (opers[i + 1].equals("+")) {
				partNum = nums[i + 1] + nums[i + 2];
			} else if (opers[i + 1].equals("-")) {
				partNum = nums[i + 1] - nums[i + 2];
			} else if (opers[i + 1].equals("*")) {
				partNum = nums[i + 1] * nums[i + 2];
			}
		}
		if (opers[i].equals("+")) {
			if (partNum != 999) {
				resNum = resNum + partNum;
				return;
			}
			resNum += nums[i + 1];
			return;
		}
		if (opers[i].equals("-")) {
			if (partNum != 999) {
				resNum = resNum - partNum;
				return;
			}
			resNum -= nums[i + 1];
			return;
		}
		if (opers[i].equals("*")) {
			if (partNum != 999) {
				resNum = resNum * partNum;
				return;
			}
			resNum *= nums[i + 1];
			return;

		}

	}
}
