import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Solution1953{
	static int N,M,R,C,L;
	static int[][] map;
	static int[][][] dir= {
			{{-1,0},{1,0},{0,-1},{0,1}},
			{{-1,0},{1,0}},
			{{0,-1},{0,1}},
			{{-1,0},{0,1}},
			{{1,0},{0,1}},
			{{1,0},{0,-1}},
			{{-1,0},{0,-1}}
	};
	static int[][] chk;
	
	static class Pos{
		int x,y,num;
		Pos(int x,int y,int num){
			this.x=x;
			this.y=y;
			this.num=num;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			chk = new int[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<Pos> q = new LinkedList<>();
			q.offer(new Pos(R,C,map[R][C]));
			chk[R][C]=1; //처음 지점 방문 체크
			
			int qSize,nx,ny;
			Pos p;
			
			for(int t=1;t<L;t++) {
				qSize = q.size();
				for(int s=0;s<qSize;s++) {
					p=q.poll();
					for(int i=0;i<dir[p.num-1].length;i++) {
						nx = p.x+dir[p.num-1][i][0];
						ny = p.y+dir[p.num-1][i][1];
						if(nx<0||nx>=N||ny<0||ny>=M||chk[nx][ny]==1||map[nx][ny]==0) continue;
//						가려는 곳과 연결될 수 있는 지 체크하기 위함.
						int[] possibleChk= {-dir[p.num-1][i][0],-dir[p.num-1][i][1]};
						
						for(int j=0;j<dir[map[nx][ny]-1].length;j++) {
							if(dir[map[nx][ny]-1][j][0]==possibleChk[0] &&
									dir[map[nx][ny]-1][j][1]==possibleChk[1]) {
								chk[nx][ny]=1;
								q.offer(new Pos(nx,ny,map[nx][ny]));
							}
						}
					}
				}
			}
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(chk[i][j]==1) {
						cnt++;
					}
				}
			}
			System.out.println("#"+tc+" "+cnt);
			
		}
	}
}

