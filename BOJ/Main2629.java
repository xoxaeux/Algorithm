import java.util.*;

public class Main2629 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] chk= new boolean[40001];

		int now,max = 0;
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		for(int n=0;n<N;n++) {
			now = sc.nextInt();
			for(int i=1;i<=max;i++) {
				if(chk[i]==true) {
					q.offer(i+now);
					q.offer(Math.abs(now-i));
				}
			}
			chk[now]=true;
			while(!q.isEmpty()) {
				int idx = q.poll();
				chk[idx]=true;
			}
			max+=now;
		}
		
		int M = sc.nextInt();
		for(int i=0;i<M;i++) {
			if(chk[sc.nextInt()])	System.out.print("Y ");
			else System.out.print("N ");
		}
	}
}
