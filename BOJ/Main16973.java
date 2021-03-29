import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16973 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int N,M,H,W,Sr,Sc,Fr,Fc;
	static int[][] map;
	static boolean[][] chk;
	
	static class Pair{
		int x,y,cnt;
		public Pair(int x,int y,int cnt) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1;j<=M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Sr = Integer.parseInt(st.nextToken());
		Sc = Integer.parseInt(st.nextToken());
		Fr = Integer.parseInt(st.nextToken());
		Fc = Integer.parseInt(st.nextToken());
		if(Sr==Fr && Sc==Fc) {
			System.out.println(0);
			return;
		}
		
//		직사각형이 있는 칸을 전부 체크하자. -> bfs로 해결
		chk=new boolean[N+1][M+1];
		System.out.println(bfs(Sr,Sc));
	}
	static int bfs(int x,int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x,y,0));
		int nx,ny;
		boolean flag;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i=0;i<4;i++) {
				nx=p.x+dx[i];
				ny=p.y+dy[i];
				if(nx<1 ||ny<1 || nx+H>=N+2 || ny+W>=M+2)continue;
				if(chk[nx][ny]) continue;
				
				chk[nx][ny]=true;
				flag=true;
				if(i==0) {
					for(int m=0;m<W;m++) {
						if(map[nx][ny+m]==1) {
							flag=false;
							break;
						}
					}
				}else if(i==1) {
					for(int m=0;m<W;m++) {
						if(map[nx+H-1][ny+m]==1) {
							flag=false;
							break;
						}
					}
				}else if(i==2) {
					for(int n=0;n<H;n++) {
						if(map[nx+n][ny]==1) {
							flag=false;
							break;
						}
					}
				}else {
					for(int n=0;n<H;n++) {
						if(map[nx+n][ny+W-1]==1) {
							flag=false;
							break;
						}
					}
				}
				
				if(flag) {
					q.offer(new Pair(nx,ny,p.cnt+1));
					if(nx==Fr && ny==Fc) {
						return(p.cnt+1);
					}
				}
			}
		}
		return(-1);
	}
	
}
