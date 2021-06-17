import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main16918 {
	static int R,C,N;
	static String[][][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new String[N+1][R][C];
		
		String strIn;
		for(int i=0;i<R;i++) {
			strIn = br.readLine();
			for(int j=0;j<C;j++) {
				// t=1일 경우 초기화
				map[0][i][j] = Character.toString(strIn.charAt(j));
				map[1][i][j] = Character.toString(strIn.charAt(j));
			}
		}
		
		// execute.
		// 애초에 짝수라면 할 필요없이 출력.
		if(N%2==0) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					System.out.print("O");
				}
				System.out.println();
			}
			return;
		}
		
		for(int t=2;t<=N;t++) {
			// 짝수에는 설치한 폭탄의 위치가 남게 된다.
			if(t%2==0) {
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						if(map[t-1][i][j].equals(".")) {
							map[t][i][j] = "O";
						}else {
							map[t][i][j] = ".";
						}
					}
				}
			}
			// 홀수에는 현재 남은 폭탄의 위치가 남게 된다.
			else	bomb(t);
		}
		
		//홀수의 경우 출력.
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[N][i][j]);
			}
			System.out.println();
		}
	}
	
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static int nx,ny;
	private static void bomb(int x) {
		//우선 현재 단계에 폭탄 채워넣기.
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				Arrays.fill(map[x][i],"O");
			}
		}
		// 3초 전에 폭탄 터트리기.
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				// 3초 전에 설치한 폭탄인지 + 아직 남아있는 폭탄인지(2초전 확인).
				if(map[x-3][i][j].equals("O") && map[x-2][i][j].equals("O")) {
					map[x][i][j]=".";
					for(int t=0;t<4;t++) {
						nx = i + dir[t][0];
						ny = j + dir[t][1];
						if(nx<0||nx>R-1||ny<0||ny>C-1)continue;
						map[x][nx][ny]=".";
					}
				}
			}
		}
	}
}
