import java.util.*;

public class Main1003 {
	static int count0=0,count1=0;
	static int[][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		memo = new int[41][2];
		memo[0][0]=1;
		memo[0][1]=0;
		memo[1][0]=0;
		memo[1][1]=1;
		
		for (int i=2;i<41;i++) {
			memo[i][0]=memo[i-1][0]+memo[i-2][0];
			memo[i][1]=memo[i-1][1]+memo[i-2][1];

		}
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			System.out.println(memo[n][0]+" "+memo[n][1]);
		}
	}
}
