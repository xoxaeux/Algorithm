import java.util.*;

public class Main1463 {
	static int[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memo = new int[N+1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		sol(N,0);
		System.out.println(memo[1]);
	}

	private static void sol(int n,int cnt) {
		if(n==1) {
			if(memo[1]>cnt) memo[1]=cnt;
			return;
		}
		if(n%3==0 && memo[n/3]-1>cnt) {//현재 값이 이전의 값보다 작다면 실행
			memo[n/3]=cnt+1;
			sol(n/3,cnt+1);
		}
		if(n%2==0 && memo[n/2]-1>cnt) {
			memo[n/2]=cnt+1;
			sol(n/2,cnt+1);
		}
		if(memo[n-1]-1>cnt) {
			memo[n-1]=cnt+1;
			sol(n-1,cnt+1);
		}
	}
}
