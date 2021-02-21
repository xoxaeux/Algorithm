import java.util.Scanner;

public class Main2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[101][101];
		int x, y;
		int res = 0;
		for (int n = 0; n < N; n++) {
			x = sc.nextInt();
			y = sc.nextInt();
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (map[i][j] == 0) {
						map[i][j] = 1;
						res++;
					}
				}
			}
		}
		System.out.println(res);
	}
}
