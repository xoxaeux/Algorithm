import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution2115{
	static int N,M,C;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxCnt1=0;
			maxCnt2=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
//					System.out.println(i+" "+j);
					if(j+M>N) break;
					
					for(int r=1;r<=M;r++) {	//1개부터 M개까지 뽑기
						comb=new int[r];
						combination(i,j,r,0,0,false);
					}
				}
			}
			
//			2번째 시도.
			int[] xyList = pick.get(0);
			int nx= xyList[0];
			int ny= xyList[1];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(j+M>N) break;
					if(i==nx && j>=ny-M+1 && j<ny+M) continue;	//겹치는 영역이라면,
					
					
					for(int r=1;r<=M;r++) {	//1개부터 M개까지 뽑기
						comb=new int[r];
						combination(i,j,r,0,0,true);
					}
				}
			}
			System.out.println("#"+tc+" "+(int)(maxCnt1+maxCnt2));			
		}
	}
	static int sysX,sysY;
	static int cnt,maxCnt1,maxCnt2;
	static int[] comb;
	static int sum;
	static List<int[]> pick = new ArrayList<>();
	private static void combination(int x, int y,int r,int idx,int start,boolean picked) {
		if(idx==r) {
			sum=0;
			cnt=0;
			for(int i=0;i<r;i++) {
				sum+=map[x][y+comb[i]];
				if(sum>C) return;
				cnt+=(int) Math.pow(map[x][y+comb[i]],2);
			}
			if(!picked && maxCnt1<cnt) {
				maxCnt1=cnt;
				pick.clear();
				pick.add(new int[] {x,y});	//처음시도에는 가장 큰 조합이 담김.
			}
			if(picked && maxCnt2<cnt) {
				maxCnt2=cnt;
				sysX=x;
				sysY=y;
			}
			return;
		}
		for(int i=start;i<M;i++) {
			comb[idx]=i;
			combination(x,y,r,idx+1,i+1,picked);
		}
		
	}
}