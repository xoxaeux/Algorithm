import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main17144 {
	static int R,C,T;
	static int[][] map,nMap;
	static int airC;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					airC=i;	//최종적으로 공기청정기의 아래좌표가 담긴다.
				}
			}
		}
		
		for(int t=0;t<T;t++) {
//			1. 미세먼지 확산
			nMap = new int[R][C];
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(map[i][j]==-1) {
						nMap[i][j]=-1;
						continue;
					}
					if(map[i][j]>0) {
//						cnt=0;
					}
				}
			}
		}
		
	}
}
