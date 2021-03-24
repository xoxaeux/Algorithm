import java.util.*;

public class Main2583 {
	static int N, M;
	static boolean[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static List<Integer> nums = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		int K = sc.nextInt();

		map = new boolean[N][M];
		int x1, y1, x2, y2;
		for (int i = 0; i < K; i++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					map[x][y] = true;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!map[i][j]) {
					bfs(i, j);
				}
			}
		}
		nums.sort(null);
		Iterator<Integer> iter = nums.iterator();
		System.out.println(nums.size());
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}

	private static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		q.add(y);
		
		int cnt=1,nx, ny;
		map[x][y]=true;
		while (!q.isEmpty()) {
			x=q.poll();
			y=q.poll();
			
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (!map[nx][ny]) {
						map[nx][ny] = true;
						cnt++;
						q.add(nx);
						q.add(ny);
					}
				}
			}
		}
		nums.add(cnt);
	}
}
