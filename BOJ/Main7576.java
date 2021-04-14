import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main7576 {
	static class Pair{
		int x;
		int y;
		Pair(int x,int y) {
			this.x=x;
			this.y=y;
		}
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(x).append(" ").append(y);
			return sb.toString();
		}
	}
	static int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
	static int[][] map;
	
	static int M,N,day=-1;
	static Queue<Pair> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		boolean flag=false; //익지 않은 토마토가 한 개라도 있는가.
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					flag=true;
				}
				if(map[i][j]==1) {
					q.offer(new Pair(i,j));
				}
			}
		}
		if(!flag) {
			System.out.println(0);
			return;
		}
		if(q.isEmpty()) {
			System.out.println(-1);
			return;
		}
		bfs();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(day);
	}
	private static void bfs() {
		int x,y,nx,ny,tryCnt;
		Pair tom;
		while(!q.isEmpty()) {
			day++;
			tryCnt = q.size(); //들어있는 queue의 수만큼 반복하는 변수
			for(int t=0;t<tryCnt;t++) {	
				tom = q.poll();
				x=tom.x;
				y=tom.y;
				for(int i=0;i<4;i++) {
					nx=x+dir[i][0];
					ny=y+dir[i][1];
					if(nx<0||nx>=N||ny<0||ny>=M) continue;
					if(map[nx][ny]==0) {
						map[nx][ny]=1;
						q.offer(new Pair(nx,ny));
					}
				}
			}
		}
	}
}
