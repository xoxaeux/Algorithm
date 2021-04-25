import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution5644{
	static int[][] dir= {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	static class Pair{
		int x;
		int y;
		Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static class Bat implements Comparable<Bat>{
		int x;
		int y;
		int c;//거리
		int p;
		Bat(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}

		@Override
		public int compareTo(Bat o) {
			return o.p-this.p;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int time,batCnt;
		int[][] move;
		PriorityQueue<Bat> batPQ;
		Queue<Bat> batQ;
		int x,y,c,p;
		
		for (int tc=1;tc<=T;tc++) {			
			st = new StringTokenizer(br.readLine());
//			0초부터 충전가능이므로. time += 1
			time = Integer.parseInt(st.nextToken())+1;
			batCnt = Integer.parseInt(st.nextToken());
			
			move = new int [time][2];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<time;i++) {
				move[i][0]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<time;i++) {
				move[i][1]=Integer.parseInt(st.nextToken());
			}
			
//			power가 높은 순서대로 정렬하기 위해 pq사용.
			batPQ = new PriorityQueue<>();
			batQ = new LinkedList<>();
			for(int i=0;i<batCnt;i++) {
				st = new StringTokenizer(br.readLine());
				y=Integer.parseInt(st.nextToken())-1;
				x=Integer.parseInt(st.nextToken())-1;
				c=Integer.parseInt(st.nextToken());
				p=Integer.parseInt(st.nextToken());
				batPQ.add(new Bat(x,y,c,p));
			}
//			priorityqueue는 iterator순서 따르지 않으므로 다시 queue에 넣어주자.
			while(!batPQ.isEmpty()) {
				batQ.offer(batPQ.poll());
			}
			
			
			Iterator<Bat> iter=null;
			Bat batNow;

//			initialize
			Pair a = new Pair(0,0);
			Pair b = new Pair(9,9);
			
//			execute
			int res=0;
			int aX,aY,bX,bY,batA,batB;
			
//			만약, A와 B가 같은 것을 선택했다면 둘의 차선책 중 최댓값을 선택한다.
			int batFirA,batFirB;
			int batSecA,batSecB;
			
			for(int i=0;i<time;i++) {
				aX=a.x+dir[move[i][0]][0];
				aY=a.y+dir[move[i][0]][1];
				
				iter = batQ.iterator();
				batA=0;	//A가 선택한 배터리의 index.
				batFirA=0; //A의 최선책의 power
				batSecA=0; //A의 차선책의 power
				while(iter.hasNext()) {
					batNow = iter.next();
					if(batNow.c>=Math.abs(batNow.x-aX)+Math.abs(batNow.y-aY)) {
						res+=batNow.p;
//						System.out.println(i+" A "+aX+" "+aY+" "+batNow.p);
						
						break;
					}
					batA++;
				}
				
				// b의 위치에서 한 번 더 진행한다. 단, batA(A가 가져간 배터리) 제외하고 선택.
				bX=b.x+dir[move[i][1]][0];
				bY=b.y+dir[move[i][1]][1];
				
				iter = batQ.iterator();
				batB=0;
				
				while(iter.hasNext()) {
					batNow = iter.next();
					if(batA==batB) {
						batB++;
						continue;
					}
					if(batNow.c>=Math.abs(batNow.x-bX)+Math.abs(batNow.y-bY)) {
						res+=batNow.p;

//						System.out.println(i+" B "+bX+" "+bY+" "+batNow.p);
						break;
					}
					batB++;
				}
				a = new Pair(aX,aY);
				b = new Pair(bX,bY);
			}
			System.out.println("#"+tc+" "+res);
		}
	}
}

