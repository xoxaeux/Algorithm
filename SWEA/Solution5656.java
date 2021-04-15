import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution5656{
	static int N,W,H;
	static int[][] map;
	static int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}	
			}
//			중복순열.
			minCnt = Integer.MAX_VALUE;
			perm=new int[N];
			permutation(W,N,0);
			
			System.out.println("#"+tc+" "+minCnt);
		}
	}

	static int cnt,minCnt;
	static int[] perm;
	static int[][] nMap;
	static int point;
	private static void permutation(int n, int r, int idx) {
		if(idx==r) {
//			deepcopy
			nMap=new int[H][W];
			for(int i=0;i<H;i++) {
				System.arraycopy(map[i], 0, nMap[i], 0, W);					
			}
//			벽돌깨기
			for(int t=0;t<r;t++) {
				point=-1;	//만약 떨어뜨린 곳이 끝까지 0이라면 할 필요 X.
				for(int i=0;i<H;i++) {
					if(nMap[i][perm[t]]!=0) {
						point=i;
						break;
					}
				}
				if(point==-1) {	//떨어뜨린 곳이 0이었는데 아직 벽돌이 하나라도 있는 경우라면.
					for(int i=0;i<H;i++) {
						for(int j=0;j<W;j++) {
							if(nMap[i][j]!=0) {
								return;
							}
						}
					}
					minCnt=0;
					return;
				}else {
//					1. 구슬닿은 곳부터 벽돌 부수기
					bang(point,perm[t]);
//					2. 벽돌 아래로 당기기
					down();
				}
				
			}
//			남아있는 벽돌 갯수세기
			cnt=0;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(nMap[i][j]!=0) {
						cnt++;
					}
				}
			}
			minCnt=Math.min(cnt, minCnt);			
			
			return;
		}
		
//		순열 원소 뽑기
		for(int i=0;i<n;i++) {
			perm[idx]=i;
			permutation(n,r,idx+1);
		}
		
	}
	
	static int downPoint;
	private static void down() {
		for(int i=0;i<W;i++) {
			downPoint=-1;
			for(int j=H-1;j>=0;j--) { //아래부터 위로 올라가면서 0인 지점확인.
				if(nMap[j][i]==0 && downPoint==-1) {
//					0인 공간이 남아있는 곳을 저장해둔다.
					downPoint=j;
					continue;
				}
				if(downPoint!=-1 && nMap[j][i]!=0) {
//					아래에 0인 공간이 있는데, 숫자인 벽돌을 만난다면,
					nMap[downPoint][i]=nMap[j][i];
					nMap[j][i]=0;
					downPoint--;
				}
			}
		}
		
	}

	static int nx,ny;
	private static void bang(int x, int y) {
		int num = nMap[x][y];
		nMap[x][y]=0;
//		num만큼 퍼지기
		for(int n=1;n<num;n++) {
//			4방향
			for(int i=0;i<4;i++) {
				nx=x+dir[i][0]*n;
				ny=y+dir[i][1]*n;
				
				if(nx<0||nx>=H||ny<0||ny>=W) continue;
				bang(nx,ny);
			}
		}
		return;
	}	
}