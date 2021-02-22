import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
//		성별: 2 / 학년: 6
		int[][] stus = new int[2][6];
		int S, Y;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken()) - 1;
			stus[S][Y]++;
		}
		int ans = 0;
		for (int[] stu : stus) {
			for (int s : stu) {
				ans+=s/K;
				if(s%K>0) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
