import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1197{
	static class info implements Comparable<info> {
		int p1, p2, dist;

		public info(int p1, int p2, int dist) {
			this.p1 = p1;
			this.p2 = p2;
			this.dist = dist;
		}

		public int compareTo(info o) {
			return this.dist - o.dist;
		}
	}

	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int A,B,C;
		PriorityQueue<info> pq = new PriorityQueue<>();
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			pq.add(new info(A,B,C));
		}
		int cnt =0;
		
//		유니온파인드 하기위함.
		parents = new int[V+1];
		for(int i=0;i<V+1;i++) {
			parents[i]=i;
		}
		int fx,fy;
		while(!pq.isEmpty()) {
			info i = pq.poll();
			fx=find(i.p1);
			fy=find(i.p2);
			if(fx==fy)continue;
			else if(fx>fy){
				parents[fx]=fy;
			}else {
				parents[fy]=fx;
			}
			cnt+=i.dist;
		}
		System.out.println(cnt);
	}

	private static int find(int p) {
		if(parents[p]==p) {
			return p;
		}
		return find(parents[p]);
	}
}

