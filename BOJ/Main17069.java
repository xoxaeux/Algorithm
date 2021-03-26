import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*
dp[n][0] = dp[n-1][0]+dp[n-1][2]
dp[n][1] = dp[n-1][1]+dp[n-1][2]
dp[n][2] = dp[n-1][0]+dp[n-1][1]+dp[n-1][2]
*/
public class Main17069 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		long [][][] dp = new long[N][N][3]; //N,N까지 오기 위한 가로, 세로, 대각선
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				
			}
		}
		dp[0][1][0]=1; //초기 시작점
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if (j<N-1 && map[i][j+1]==0) { //옆
					dp[i][j+1][0]+=(dp[i][j][0]+dp[i][j][2]);
					if(i<N-1 && map[i+1][j]==0 && map[i+1][j+1]==0) { //대각선
						dp[i+1][j+1][2]+=(dp[i][j][0]+dp[i][j][1]+dp[i][j][2]);
					}
				}
				if(i<N-1 && map[i+1][j]==0) { //아래
					dp[i+1][j][1]+=(dp[i][j][1]+dp[i][j][2]);
				}
			}
		}
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);

	}
}
