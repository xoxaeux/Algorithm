import java.util.*;

public class Main2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		if (N <= 5) {
			if (N != 3 && N != 5) {
				System.out.println(-1);
			}
			else {
				System.out.println(1);
			}
			return;
		}
		dp[3] = 1;
		dp[5] = 1;

		for (int i = 6; i <= N; i++) {
			if (dp[i - 3] != Integer.MAX_VALUE) {
				dp[i] = Integer.min(dp[i], dp[i - 3]) + 1;
			}
			if (dp[i - 5] != Integer.MAX_VALUE) {
				dp[i] = Integer.min(dp[i], dp[i - 5]) + 1;
			}
		}
		if (dp[N] == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(dp[N]);
	}
}
