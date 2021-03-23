package jungol;

import java.util.Scanner;

public class Main1411 {
	static int[] dp;
	static int sol(int n) {
		/*
		 * n-2 뒤에 붙이는 경우 + n-1뒤에 붙이는 경우
		 */
		dp[1]=1;
		dp[2]=3;
		
		for(int i=3;i<=n;i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2])%20100529;
		}
		return dp[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[N+1];
		
		System.out.println(sol(N));
	}

	
}
