import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main17406 {
	static int N, M, K;
	static int[][] map;
	static int[][] spinSet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		spinSet = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			spinSet[i][0] = Integer.parseInt(st.nextToken())-1;
			spinSet[i][1] = Integer.parseInt(st.nextToken())-1;
			spinSet[i][2] = Integer.parseInt(st.nextToken());
		}
		perm = new int[K];
		chk = new boolean[K];
		permutation(0);
		System.out.println(maxCnt);
	}

	static int[] perm;
	static boolean[] chk;
	static int[][] nMap;
	static int cnt,maxCnt=Integer.MAX_VALUE;
	static int x,y,range;
	private static void permutation(int idx) {
		if (idx == K) {
			// 배열 복사해서 사용하기.
			nMap = new int[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					nMap[i][j] = map[i][j];
				}
			}
			
			// 순열에서 하나씩 꺼내 알맞게 회전시키기.
			for (int i=0;i<K;i++) {
				x=spinSet[perm[i]][0];
				y=spinSet[perm[i]][1];
				range=spinSet[perm[i]][2];
				for(int r=1;r<=range;r++) {
					spin(x-r,y-r,r);
				}
			}
			
			
			// 회전 마치고, 배열의 값 구하기.
			for(int i=0;i<N;i++) {
				cnt=0;
				for(int j=0;j<M;j++) {
					cnt+=nMap[i][j];
				}
				maxCnt=Math.min(maxCnt, cnt);
			}
			
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!chk[i]) {
				perm[idx] = i;
				chk[i] = true;
				permutation(idx + 1);
				chk[i] = false;
			}
		}
	}
	
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
	static Queue<Integer> q = new LinkedList<>();
	static int d,nx,ny;
	private static void spin(int x, int y, int r) {
		// 1. 우선 처음부터 들어갈 값 다 넣어놓기.
		// 처음값은 넣어놓고 이후에 경계값인지 확인하기.
		nx = x;
		ny = y;
		q.offer(nMap[nx][ny]);
		
		d=0;
		while(true) {
			nx += dir[d][0];
			ny += dir[d][1];

			if(nx==x && ny==y) break;
			q.add(nMap[nx][ny]);
			if(nx==x && ny==y+(2*r)) {
				d=1;
				continue;
			}
			if(nx==x+(2*r) && ny==y+(2*r)) {
				d=2;
				continue;
			}
			if(nx==x+(2*r) && ny==y) {
				d=3;
				continue;
			}
			
		}
		
		// 2. 한칸씩 이동한 후, 큐에서 꺼낸 값 집어넣기.
		d=0;
		while(true) {
			nx +=dir[d][0];
			ny +=dir[d][1];
			nMap[nx][ny] = q.poll();
			if(nx==x && ny==y+(2*r)) {
				d=1;
				continue;
			}
			if(nx==x+(2*r) && ny==y+(2*r)) {
				d=2;
				continue;
			}
			if(nx==x+(2*r) && ny==y) {
				d=3;
				continue;
			}
			if(nx==x && ny==y) break;
			
		}
	}
}

