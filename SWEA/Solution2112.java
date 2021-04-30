import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2112 {
	static int D, W, K;
	static int[][] map, insertMap;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(isPassed()) { //시도하지 않고 성공하는 경우
				System.out.println("#"+tc+" "+0);
				continue;
			}
			
			flag = false;
			cnt=1;
			
			while(true) {
				comb= new int[D];
				chk= new boolean[D];
				
//				조합만들기.
				combination(D,cnt,0,0);
				if(flag) {
					System.out.println("#"+tc+" "+cnt);
					break;
				}
				cnt++;
			}
				
		}

	}
	
	
	static int[] comb;
	static boolean[] chk;
	static boolean flag;
	private static void combination(int n, int r, int idx, int start) {
		if (idx == r) {
//			System.out.println(Arrays.toString(comb));
			execute(comb);
			return;
		}
		for (int i = start; i < n; i++) {
			if(flag)return;	//이미 숫자 정해진 경우.
			if (!chk[i]) {
				comb[idx] = i;
				chk[i] = true;
				combination(n, r, idx + 1, i);
				chk[i] = false;
			}
		}
	}


	private static void execute(int[] comb) {
		insertMap = new int[cnt][W];
		for(int i=0;i<cnt;i++) {
			for(int j=0;j<W;j++) {
				insertMap[i][j]=map[comb[i]][j];	//다시 돌려놓을 정보 저장
			}
		}
		
		for(int i=0;i<cnt;i++) {
			for( int j=0;j<W;j++) {
				map[comb[i]][j]=1;	//1로 교체.
			}
			if(isPassed()) {
				flag=true;
				return;
			}
			
			for( int j=0;j<W;j++) {
				map[comb[i]][j]=0;	//0으로 교체.
			}
			if(isPassed()) {
				flag=true;
				return;
			}			
		}
		
		for(int i=0;i<cnt;i++) {
			for( int j=0;j<W;j++) {
				map[comb[i]][j]=insertMap[i][j];	//다시 원래대로 교체.
			}
		}
	}

	static int t,tCnt;
	static boolean flagP;
	private static boolean isPassed() {
		for (int j = 0; j < W; j++) {
			t=map[0][j];
			tCnt=1;
			flagP=false;
			for (int i = 1; i < D; i++) {
				if(t==map[i][j]) {
					tCnt++;
					if(tCnt>=K) {
						flagP=true;
						break;
					}
				}else {
					t=map[i][j];
					tCnt=1;
				}
			}
			if(!flagP) {
				return false;
			}
		}
		return true;

	}
}
