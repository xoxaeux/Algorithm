import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main17143 {
	static class Shark{
		int r,c,s,d,z;
		Shark(int r,int c,int s,int d,int z){
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(z);
			return sb.toString();
		}
	}
	static Queue<Shark> q = new LinkedList<>();
	static Iterator<Shark> iter;
	
	static int R,C,M;
	static int r,c,s,d,z;
	static Shark[][][] map;	//Shark 저장하는 배열.
	static int[][] sharks;
	
	static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
	static int cnt, maxCnt = 0;	//잡을,잡은 Shark 크기 저장.
	static int now;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		3차원 배열로, 이전과 현재 위치에 있는 상어 구분.
		map = new Shark[2][R][C];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken())-1;
			z = Integer.parseInt(st.nextToken());
			
			map[0][r][c] = new Shark(r,c,s,d,z);
		}
		
		now = 0;
		for(int y=0;y<C;y++) {	//인간 위치. 오른쪽으로 이동.
			cnt=0;
//			1.잡기
			for(int x=0;x<R;x++) {	//인간 위치에서 아래로 내려가면서
				if(map[now][x][y]!=null) { //shark 있다면,
					cnt=map[now][x][y].z;	//크기 더해주고
					map[now][x][y]=null;		//shark 없애기
					break;
				}
			}
			maxCnt+=cnt;
			System.out.println(cnt);
			for(Shark[] ma : map[now]) {
				System.out.println(Arrays.toString(ma));
			}

//			2.상어 움직이기
			for(int i=0;i<R;i++) {	//모든 map 돌면서
				for(int j=0;j<C;j++) {
					if(map[now][i][j]!=null) { //shark 있다면,
						move(map[now][i][j],now); //움직이기.
						map[now][i][j] = null;
					}
				}
			}
//			3.시간 변경하기.
			if(now==0)now=1;
			else if(now==1)now=0;
		}
		System.out.println(maxCnt);
	}
	
	static int nr,nc,nd,nt;
	private static void move(Shark S,int time) {
//		shark가 벽에 부딪히면 방향 바뀜.
//		규격에서 -1을 한 값으로 나눈다.
//		몫은 방향결정(짝수: 동일)/나머지는 위치.
//		몫이 짝수라면, 0부터 나머지만큼.	방향은 동일
//		몫이 홀수라면, 규격-1부터 나머지만큼 -한 위치. 방향 바꾸기
//		
//		-방향이라면, 위치만큼 -하기. 0보다 작다면 방향바꾸고 0부터 +로 진행.
		nr = S.r;
		nc = S.c;
		switch(S.d) {
		case 0: //위,-방향
			nr = S.r + dir[0][0]*S.s;
			if(nr<0) {
				nr = Math.abs(nr);
				if((nr/(R-1))%2==0) {
					nr%=(R-1);
					nd = 1;
				}
				else{
					nr=(R-1) - nr%(R-1);
					nd = 0;
				}
			}
			break;
			
		case 1: //아래,+방향
			nr = S.r + dir[1][0]*S.s;
			if(nr>R-1) {
				if((nr/(R-1))%2==0) {
					nr%=(R-1);
					nd = 1;
				}
				else{
					nr=(R-1) - nr%(R-1);
					nd = 0;
				}
			}
			break;
			
		case 2: //우,+방향
			nc = S.c + dir[2][0]*S.s;
			if(nc>C-1) {
				if((nc/(C-1))%2==0) {
					nc%=(C-1);
					nd = 1;
				}
				else{
					nc=(C-1) - nc%(C-1);
					nd = 0;
				}
			}
			break;
		
		case 3: //좌,-방향
			nc = S.c + dir[3][0]*S.s;
			if(nc<0) {
				nc = Math.abs(nc);
				if((nc/(C-1))%2==0) {
					nc%=(C-1);
					nd = 1;
				}
				else{
					nc=(C-1) - nc%(C-1);
					nd = 0;
				}
			}
			break;
		}
		
		if(time==0)nt=1;
		else if(time==1)nt=0;
		
		if(map[nt][nr][nc]!=null) { //이미 해당 칸에 상어가 있고,
			if(map[nt][nr][nc].z < S.z) {	//현재 상어가 더 크다면
				map[nt][nr][nc] = new Shark(nr,nc,S.s,nd,S.z); //현재 상어 저장
			}
			return;
		}else {
			map[nt][nr][nc] = new Shark(nr,nc,S.s,nd,S.z);
		}
	}
}
