import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1806 {
	static int N,S;
	static int num,sum;
	static int res=Integer.MAX_VALUE;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			num = Integer.parseInt(st.nextToken());
			q.add(num);
			sum+=num;
			if(sum<S) continue;
			solve();
		}
		if(res == Integer.MAX_VALUE)	System.out.println(0);
		else	System.out.println(res);
		
	}
	static void solve() {
		if(q.size()<res)	res = q.size();
		while(q.size()>1) {
			sum-=q.poll();
			if(sum<S) break;
			if(q.size()<res)	res = q.size();
		}
	}
}
