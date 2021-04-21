import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main15683 {
	static int N,M;
	static int[] cList;
	static int[][] map,chk;
	static int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
	
	static class CCTV{
		int x,y,num;
		CCTV(int x,int y,int num){
			this.x=x;
			this.y=y;
			this.num=num;
		}
	}
	
	static Queue<CCTV> q = new LinkedList<>();
	static Iterator<CCTV> iter;
	static int minCnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==0) minCnt++;
				if(map[i][j]!=0 && map[i][j]!=6) {
					q.offer(new CCTV(i,j,map[i][j]));
				}
			}
		}
//		CCTV번호만 저장하는 list만들기.
		int idx=0;
		if(q.size()!=0) {
			cList = new int[q.size()];
			iter = q.iterator();
			while(iter.hasNext()) {
				cList[idx++]=iter.next().num;
			}
		}
		
//		중복순열.
		perm = new int[idx];
		permutation(idx,0);
		System.out.println(minCnt);
	}
	
	
	static CCTV c;
	static int[] perm;
	static int cnt;
	private static void permutation(int n, int idx) {
		if(idx==n) {
			chk = new int[N][M];
			iter = q.iterator();
			for(int i=0;i<n;i++) {
				c = iter.next();
				check(c,perm[i]);
			}
			
			cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==0 && chk[i][j]==0) {
						cnt++;
					}
				}
			}
			
			if(minCnt>cnt) {
				minCnt=cnt;
			}
			return;
		}
		for(int i=0;i<4;i++) {
//			2번과 5번의 형태는 4개가 아니므로.
			if(cList[idx]==2 && (i==2||i==3))continue;
			if(cList[idx]==5 && i!=0)continue;
			perm[idx]=i;
			permutation(n,idx+1);
		}
	}

	

	private static void check(CCTV c, int d) {
		int nx=c.x,ny=c.y;
		chk[nx][ny]=1;
		
		switch(c.num) {
		case 1:
			while(true) {
				nx+=dir[d][0];
				ny+=dir[d][1];
				if(!isAvailable(nx,ny))break;
			}
			break;
			
		case 2:
			while(true) {
				nx+=dir[d][0];
				ny+=dir[d][1];
				if(!isAvailable(nx,ny))break;
			}
			nx=c.x;
			ny=c.y;
			while(true) {
				nx-=dir[d][0];
				ny-=dir[d][1];
				if(!isAvailable(nx,ny))break;
			}
			break;
			
		case 3:
			while(true) {
				nx+=dir[d][0];
				ny+=dir[d][1];
				if(!isAvailable(nx,ny))break;
			}
			nx=c.x;
			ny=c.y;
			d++;
			if(d==4)d=0;
			while(true) {
				nx+=dir[d][0];
				ny+=dir[d][1];
				if(!isAvailable(nx,ny))break;
			}
			break;
			
		case 4:
			while(true) {
				nx+=dir[d][0];
				ny+=dir[d][1];
				if(!isAvailable(nx,ny))break;
			}
			nx=c.x;
			ny=c.y;
			d++;
			if(d==4)d=0;
			while(true) {
				nx+=dir[d][0];
				ny+=dir[d][1];
				if(!isAvailable(nx,ny))break;
			}
			nx=c.x;
			ny=c.y;
			d++;
			if(d==4)d=0;
			while(true) {
				nx+=dir[d][0];
				ny+=dir[d][1];
				if(!isAvailable(nx,ny))break;
			}
			break;
			
		case 5:
			while(true) {
				nx+=dir[d][0];
				ny+=dir[d][1];
				if(!isAvailable(nx,ny))break;
			}
			nx=c.x;
			ny=c.y;
			d++;
			if(d==4)d=0;
			while(true) {
				nx+=dir[d][0];
				ny+=dir[d][1];
				if(!isAvailable(nx,ny))break;
			}
			nx=c.x;
			ny=c.y;
			d++;
			if(d==4)d=0;
			while(true) {
				nx+=dir[d][0];
				ny+=dir[d][1];
				if(!isAvailable(nx,ny))break;
			}
			nx=c.x;
			ny=c.y;
			d++;
			if(d==4)d=0;
			while(true) {
				nx+=dir[d][0];
				ny+=dir[d][1];
				if(!isAvailable(nx,ny))break;
			}
			break;
		}	
	}


	private static boolean isAvailable(int nx, int ny) {
		if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] != 6) {
			chk[nx][ny] = 1;
			return true;
		}
		return false;
	}
}
