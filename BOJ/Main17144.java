import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main17144{
	static int R,C,T;
	static int[][] map;
	static int[][] nMap;
	static int airCon;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());	
		map = new int[R][C];
		nMap = new int[R][C];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					map[i][j]=0;
					airCon = i; // 공기청정기 위치의 아랫행을 저장한다.
				}
			}
		}
		
		// execute.
		for(int t=0;t<T;t++) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					nMap[i][j] = map[i][j];
				}
			}
			map = new int[R][C];

			spread();
			swallow();
		}
		
		// output.
		int sol = 0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]!=0)	sol+=map[i][j];
			}
		}
		System.out.println(sol);
	}
	
	static int spreadAir;
	static int spareAir;
	static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
	static int nx,ny;
	public static void spread() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(nMap[i][j] != 0) { // 먼지발견
					spareAir = nMap[i][j];
					spreadAir = nMap[i][j]/5;
					for(int d=0;d<4;d++) { // 사방탐색
						nx = i+dir[d][0];
						ny = j+dir[d][1];
						// 칸이 없거나 공기청정기 -> skip.
						if(nx<0 || nx>R-1 || ny<0 || ny>C-1) continue;
						if((nx==airCon-1&&ny==0)|| (nx==airCon&&ny==0)) continue;
						// 가능한 칸에 확산시키기.
						spareAir -= spreadAir;
						map[nx][ny]+=spreadAir;
					}
					map[i][j]+=spareAir;
				}
			}
		}
	}
	
	static int[] swallowAir;
	static int[] temp;
	public static void swallow() {
		swallowAir = new int[2];
		temp = new int[2];
		// 그림의 화살표 방향 1(동시진행).
		for(int i=1;i<=C-1;i++) {
			temp[0] = map[airCon-1][i];
			map[airCon-1][i] = swallowAir[0];
			swallowAir[0] = temp[0];
			temp[1] = map[airCon][i];
			map[airCon][i] = swallowAir[1];
			swallowAir[1] = temp[1];
		}
		// 화살표 2.
		for(int i=airCon-2;i>=0;i--) {
			temp[0] = map[i][C-1];
			map[i][C-1] = swallowAir[0];
			swallowAir[0] = temp[0];
		}
		for(int i=airCon+1;i<R;i++) {
			temp[1] = map[i][C-1];
			map[i][C-1] = swallowAir[1];
			swallowAir[1] = temp[1];
		}
		// 화살표 3(동시진행).
		for(int i=C-2;i>=0;i--) {
			temp[0] = map[0][i];
			map[0][i] = swallowAir[0];
			swallowAir[0] = temp[0];
			temp[1] = map[R-1][i];
			map[R-1][i] = swallowAir[1];
			swallowAir[1] = temp[1];
		}
		// 화살표 4.
		for(int i=1;i<airCon-1;i++) {
			temp[0] = map[i][0];
			map[i][0] = swallowAir[0];
			swallowAir[0] = temp[0];
		}
		for(int i=R-2;i>airCon;i--) {
			temp[1] = map[i][0];
			map[i][0] = swallowAir[1];
			swallowAir[1] = temp[1];
		}
		
	}
}