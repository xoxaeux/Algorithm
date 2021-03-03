import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int num;
		String[] input;
		int[][] map;
		int mid, left, right;

		for (int tc = 1; tc <= T; tc++) {
			int sum=0;
			num = Integer.parseInt(br.readLine());
			map = new int[num][num];

			for (int i = 0; i < num; i++) {
				input = br.readLine().split("");
				for (int j = 0; j < input.length; j++) {
					map[i][j] = Integer.parseInt(input[j]);
				}
			}

			mid = num / 2;
			left = mid;
			right = mid;

			for (int i = 0; i < num; i++) {
				for (int j = left; j <= right; j++) {
					sum += map[i][j];
				}
				if (i < mid) {
					left--;
					right++;
				} else if (i >= mid) {
					left++;
					right--;
				}
			}
			System.out.println("#"+tc+" "+sum);
		}

	}
}
