import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1859 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] nums = new int[N];
			int maxNum = 0, maxIdx = 0, numIn;
			for (int i = 0; i < N; i++) {
				numIn = Integer.parseInt(st.nextToken());
				if (maxNum <= numIn) {
					maxNum = numIn;
					maxIdx = i;
				}
				nums[i] = numIn;
			}
			long cnt = 0; // long으로 설정해 int 범위보다 큰 수 다룸.
			int idx = 0;
			while (true) {
				for (int i = idx; i < maxIdx; i++) {
					cnt += maxNum - nums[i];
				}
				idx = maxIdx+1;
				if (idx == nums.length) {
					break;
				}
				maxNum=0;
				for (int i = idx; i < nums.length; i++) {
					if(maxNum <=nums[i]) {
						maxNum=nums[i];
						maxIdx=i;
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
		}

	}
}
