import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int people = 0, max = 0;
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					cnt += Integer.parseInt(st.nextToken());
				}
				if (cnt > max) {
					max = cnt;
					people = 1;
				} else if (cnt == max) {
					people++;
				}
			}
			System.out.println("#" + tc + " " + people + " " + max);
		}
	}
}
