import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2564 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		// 북, 남, 서, 동
		int[][] points = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt += sol(col, row, x, y, points[i][0], points[i][1]);
			System.out.println(cnt);
		}
		System.out.println(cnt);
	}

//	방향이 서로 같다면, 차이만 구하면 된다.
//	다를 경우는 총 3가지 경우. 차이가 2라면, 서로의 위치값 +다른 선분길이
//	차이가 1일 경우, 북서/남동/북동/서남으로 나누어서 계산해보자.
//	그리고 나머지 경우는 총 길이에서 뺀 값이므로 비교해볼수 있다.
	private static int sol(int X, int Y, int x, int y, int i, int j) {
		int num;
		if (x == i) {
			num = Math.abs(y - j);
			System.out.println("1"+num);
		} else if (Math.abs(x - i) == 2) {
			if (x == 1 || x == 2) {
				num = y + j + Y;
			} else {
				num = y + j + X;
			}
		} else {// 북서 : 합이 4 / 남동 : 6 / 북동 : 5 / 서남 : 5
			if (x + i == 4) {
				num = y + j;
			} else if (x + i == 6) {
				num = (y + j + X + Y);
			} else if (x == 1 || x == 4) {
				num = X - y + j;
			} else {
				num = y + Y - j;
			}
		}
		return Math.min(num, 2*X+2*Y-num);
	}

}
