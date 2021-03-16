import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1260 {
	static boolean[][] map;
	static boolean[] chk;
	static int N, M, V;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

//		입력받기. 간선:양방향
		map = new boolean[N+1][N+1];
		int P, Q;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			Q = Integer.parseInt(st.nextToken());
			map[P][Q] = true;
			map[Q][P] = true;
		}

		chk = new boolean[N+1];
		dfs(V);
		System.out.println();
		chk = new boolean[N+1];
		bfs(V);
	}

//	DFS:재귀이용
	private static void dfs(int v) {
		chk[v] = true;
		System.out.print(v + " ");
		for (int i = 0; i < N+1; i++) {
			if (map[v][i] && !chk[i]) {
				dfs(i);
			}
		}
	}

//	BFS:큐 이용
	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(v);
		chk[v]=true;
		int node;
		while (!queue.isEmpty()) {
			node=queue.poll();
			System.out.print(node + " ");
			for (int i = 0; i < N+1; i++) {
				if (map[node][i] && !chk[i]) {
					chk[i]=true;
					queue.offer(i);
				}
			}
		}
	}
}
