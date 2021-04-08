import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3109 {
	static String[][] map;
	static int R, C;
	static int cnt;
	static String[][] chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[R][C];
		String[] strIn = new String[C];
		for (int i = 0; i < R; i++) {
			strIn = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				map[i][j] = strIn[j];
			}
		}
		chk = new String[R][C];
		for (int i = 0; i < R; i++) {
			dfs(i, 0);
		}
		System.out.println(cnt);

	}

	public static boolean dfs(int x, int y) {
		if (y == C - 1) {
			cnt++;
			return true;
		}
		if (x >= 1 && map[x - 1][y + 1].equals(".")) {
			map[x - 1][y + 1] = "x";
			if (dfs(x - 1, y + 1))
				return true;
		}
		if (map[x][y + 1].equals(".")) {
			map[x][y + 1] = "x";
			if (dfs(x, y + 1))
				return true;
		}
		if (x <= R - 2 && map[x + 1][y + 1].equals(".")) {
			map[x + 1][y + 1] = "x";
			if (dfs(x + 1, y + 1))
				return true;
		}
		return false;
	}
}
