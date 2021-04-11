import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main2206 {
	static int[] dx= {0,0,1,-1};
	static int[] dy= {1,-1,0,0};
	static int N,M;
	static int[][] map;
	static int[][] chk;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		String[] strIn = new String[M];
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			strIn=br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(strIn[j]);
			}
		}
//		chk는 거리가 아닌 뚫은 횟수로 판단.
		chk = new int[N][M];
		for(int[] c : chk) {
			Arrays.fill(c, 9);
		}
		System.out.println(bfs(0,0));		
	}
	
	public static class Point{
		int x;
		int y;
		int cnt;
		int broke;
		
		Point(int x, int y, int cnt, int broke) {
			this.x = x;
			this.y = y;
			this.cnt=cnt;
			this.broke = broke;
		}
	}
	
	static Queue<Point> q = new LinkedList<Point>();
	private static int bfs(int x, int y) {
		Point p = new Point(x,y,1,0);
		q.add(p);
		
		int cx,cy,cnt;
		int b;
		int nx,ny;
		while(!q.isEmpty()) {
			p=q.poll();
			cx=p.x;
			cy=p.y;
			cnt=p.cnt;
			b=p.broke;
			if(cx==N-1&&cy==M-1) {
				return cnt;
			}
			
			for(int i=0;i<4;i++) {
				nx = cx+dx[i];
				ny = cy+dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(map[nx][ny]==0 && chk[nx][ny]>b) {
						q.add(new Point(nx,ny,cnt+1,b));
						chk[nx][ny]=b;
					}else if(map[nx][ny]==1 && chk[nx][ny]>b && b==0) {
						q.add(new Point(nx,ny,cnt+1,b+1));
						chk[nx][ny]=b+1;
					}
				}
			}
		}
		return -1;
		
	}
}
