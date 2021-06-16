import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main16918 {
	static int R,C,N;
	static String[][] map;
	static String[][] res;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		res = new String[R][C];
		
		String strIn;
		for(int i=0;i<R;i++) {
			strIn = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = Character.toString(strIn.charAt(j));
			}
		}
		switch(N%4) {
		case 0:
			for(String[] r : res) {
				Arrays.fill(r, "O");
			}
			break;
		case 1:
		case 2:
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					res[i][j] = map[i][j];
				}
			}
			break;
		case 3:
			for(String[] r : res) {
				Arrays.fill(r, "O");
			}
			bomb();
			break;
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
	}
	
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	static int nx,ny;
	private static void bomb() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j].equals("O")) {
					res[i][j]=".";
					for(int t=0;t<4;t++) {
						nx = i + dir[t][0];
						ny = j + dir[t][1];
						if(nx<0||nx>R-1||ny<0||ny>C-1)continue;
						res[nx][ny]=".";
					}
				}
			}
		}
	}
}
