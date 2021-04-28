import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2105 {
	static int[][] dir = { { 1, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 } };
	static int T;
	static int N;
	static int[][] map;
	static boolean[] chk;
	static int startLen,endLen;
	static int cnt,MaxCnt;
	static int cx,cy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map= new int[N][N];
			
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
//			사각형 모양. x는 0부터 n-2까지 / y는 1부터 n-1까지 있는 범위 내에서 시작.
//			시작하는 변의 길이(startLen)/끝나는 변(endLen)과 마주본 변의 길이 동일->사각형.
//			시작:좌하 / 끝:우하  -> 어디까지 가능한지 체크.(cx,cy)
			
			for(int x=0;x<N-2;x++) {
				for(int y=1;y<N-1;y++) {
					
					startLen=0;
					chk[map[x][y]]=true;
					while(true) {
						cx=x+dir[0][0];
						cy=y+dir[0][1];
						if(chk[map[cx][cy]]) break;
						startLen++;
						if(cx==N-2||cy==0) break;
					}
					endLen=0;
					while(true) {
						
						cx=x+dir[3][0];
						cy=y+dir[3][1];
						endLen++;
						if(cx==N-2||cy==N-1) break;
					}
					
					execute(x,y,startLen,endLen);
				}
			}
		}
	}

	private static void execute(int x, int y, int s, int e) {
		for(int i=0;i<s;i++) {
			if(chk[map[x][y]]) {
				
			}
		}
		
	}
}
