import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution4014 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int N, X;
		int[][] map;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			X = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			가로
			int past, now, cnt, must, res=0;
			boolean flag;
			for (int i = 0; i < N; i++) {
				flag = true;
				past = map[i][0];
				cnt = 1;
				must = 0;
				for (int j = 1; j < N; j++) {
					now = map[i][j];
					if (past == now) {
						cnt += 1;
						must-=1;
						if(must==0) {
							cnt=1;
						}
					} else if (past - now == 1) {// past가 now보다 1만큼 클 경우
						if(must>0) {
							flag=false;
							break;
						}
						cnt = 1;
						must = X-1;//앞으로 무조건 있어야 하는 같은 높이 갯수.
						past = now;
					} else if (past - now == -1) {// past가 now보다 1만큼 작을 경우
						if(cnt>=X) {
							cnt=1;
							past=now;
						}else { // 아직 cnt가 X만큼 차지 않았다면.
							flag=false;
							break;
						}
					} else {
						flag=false;
						break;
					}
				}
				if(flag && must<=0) {
					res+=1;
				}
			}
//			세로
			for (int i = 0; i < N; i++) {
				flag = true;
				past = map[0][i];
				cnt = 1;
				must = 0;
				for (int j = 1; j < N; j++) {
					now = map[j][i];
					if (past == now) {
						cnt += 1;
						must-=1;
						if(must==0) {
							cnt=1;
						}
					} else if (past - now == 1) {// past가 now보다 1만큼 클 경우
						if(must>0) {
							flag=false;
							break;
						}
						cnt = 1;
						must = X-1;//앞으로 무조건 있어야 하는 같은 높이 갯수.
						past = now;
					} else if (past - now == -1) {// past가 now보다 1만큼 작을 경우
						if(cnt>=X) {
							cnt=1;
							past=now;
						}else { // 아직 cnt가 X만큼 차지 않았다면.
							flag=false;
							break;
						}
					} else {
						flag=false;
						break;
					}
				}
				if(flag && must<=0) {
					res+=1;
				}
			}
			System.out.println("#"+tc+" "+res);
		}
	}
}