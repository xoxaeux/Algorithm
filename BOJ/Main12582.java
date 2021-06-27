import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main12852{
	static int N;
	static int[] memo;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		memo = new int[N+1];
		
		// bfs & backTracking
		q.offer(1);
		int qNum,tryNum=-1,qSize;
		top:
		while(true) {
			tryNum++;
			qSize = q.size();
			for(int i=0;i<qSize;i++) {
				qNum = q.poll();
				if(qNum==N) break top;
				if(qNum*3<=N && memo[qNum*3]==0) {
					memo[qNum*3]=qNum;
					q.offer(qNum*3);
				}
				if(qNum*2<=N && memo[qNum*2]==0) {
					memo[qNum*2]=qNum;
					q.offer(qNum*2);
				}
				if(qNum+1<=N && memo[qNum+1]==0) {
					memo[qNum+1]=qNum;
					q.offer(qNum+1);
				}
			}
		}
		System.out.println(tryNum);
		printNum(N);
	}
	private static void printNum(int n) {
		if(n==1) {
			System.out.println(1);
			return;
		}
		System.out.print(n+" ");
		printNum(memo[n]);
	}
}
