import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1251 {
	static boolean[] chk;
	static int[] xList;
	static int[] yList;
	static long[][] map; //거리의 제곱값담는 배열
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			chk = new boolean[N];
			xList = new int[N];
			yList = new int[N];
			map = new long[N][N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				xList[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				yList[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			double E = Double.parseDouble(st.nextToken());

			long dist = Long.MAX_VALUE;
			int x = 0,y = 0;
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					map[i][j]=(long) (Math.pow(Math.abs(xList[i]-xList[j]),2)+
							Math.pow(Math.abs(yList[i]-yList[j]),2));
//					초기값으로 가장 작은 값선택하기 위함.
					if(dist>map[i][j]) {
						dist=map[i][j];
						x=i;
						y=j;
					}
				}
			}
			chk[x]=true;
			chk[y]=true;
			long min;
			long now;
			while(true) {
				min=Long.MAX_VALUE;
				for(int i=0;i<N;i++) {
					if(chk[i]) {
						for(int j=0;j<N;j++){
							if(!chk[j]) { //아직 미방문노드
								now = Math.max(map[i][j], map[j][i]);
								if(min>now){
									min=now;
									y=j;
								}
							}
						}
					}
				}
				if(min==Long.MAX_VALUE) {
					break;
				}
				dist+=min;
				chk[y]=true;
			}
			System.out.println("#"+tc+" "+String.format("%.0f", (dist*E)));
		}
	}
}
