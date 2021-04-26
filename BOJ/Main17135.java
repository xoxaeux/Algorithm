import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main17135 {
	static int N,M,D,cnt,maxCnt,maxDist=-1;
	static int[][] map;
	static class Enemy implements Comparable<Enemy>{
		int x, y;
		Enemy(int x, int y){
			this.x=x;
			this.y=y;
		}
		@Override
		public int compareTo(Enemy o) {
			return x-o.x;
		}
	}
	static PriorityQueue<Enemy> q = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					q.offer(new Enemy(i,j));
					if(maxDist==1) {
						maxDist=i;	//제일 멀리있는 적의 위치만큼 반복하기 위함.
					}
				}
			}
		}
		// 조합으로 3명 배치. 진행.
		combination(M,0,0);
	}
	
	static int[] comb=new int[3];
	static Enemy enemy;
	static int dis,minDis;
	static int[] selEnemy;
	static int selIdx;
	private static void combination(int n, int idx,int start) {
		if(idx==3) {
//			System.out.println(Arrays.toString(comb));
			cnt=0;
			Queue<Enemy> eq = new LinkedList<>();
			while(!q.isEmpty()) { //계속 쓰기위해 q를 복사한 eq를 사용한다.
				eq.add(q.poll());
			}
			Iterator<Enemy> iter;
			while(!eq.isEmpty()) {
				selEnemy=new int[3];
				for(int i=0;i<3;i++) {
					minDis=10000;
					iter = eq.iterator();
					selIdx=0;
					while(iter.hasNext()) {
						enemy = iter.next();
						dis=Math.abs(enemy.x-comb[i])+enemy.y;
						if(dis<=minDis) {
							selEnemy[i]=selIdx;
							minDis=dis;
						}
					}
				}
//				적 처치. 한 줄씩 당기기.
				iter = eq.iterator();
				int enemyIdx=0;
				boolean flag=false;
				while(iter.hasNext()){
					enemy=iter.next();
					for(int i=0;i<3;i++) {
						if(enemyIdx==selEnemy[i]) {
							flag=true;
							break;
						}
					}
//					if(enemyI)
					if(enemy.y==0) {
						eq.remove(enemy);
					}
					enemyIdx++;
				}
			}
		}
		for(int i=start;i<n;i++) {
			comb[idx]=i;
			combination(n,idx+1,i+1);
		}
	}
}
