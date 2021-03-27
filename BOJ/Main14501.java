import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14501 {
	static int N;
	static int[][] schedule;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		schedule = new int[N+1][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] payList = new int[N+1];
		int maxPay = 0;
		for(int i=0;i<=N;i++) {
				for(int j =i+schedule[i][0];j<=N;j++) {
				if(payList[i]+schedule[i][1]>payList[j]) {
					payList[j] = payList[i]+schedule[i][1];
					maxPay=Math.max(maxPay, payList[j]);
				}
			}
		}
		System.out.println(maxPay);	
	}
}
