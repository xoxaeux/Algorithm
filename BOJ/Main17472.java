import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17472 {
	static int N, M;
	static int[][] map, chk, island;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] islandParent;

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = -1;
				}
			}
		}
//		1. 뭉친 섬을 찾기 위해 섬의 갯수 파악 + 섬 단위로 만들기 (bfs활용)
		chk = new int[N][M];
		int nx, ny;
		int landIdx = 1;
		Queue<Pair> q = new LinkedList<>();
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (map[x][y] == -1) {
					map[x][y] = landIdx;
					q.offer(new Pair(x, y));
					while (!q.isEmpty()) {
						Pair p = q.poll();
						for (int i = 0; i < 4; i++) {
							nx = p.x + dx[i];
							ny = p.y + dy[i];
							if (0 <= nx && nx < N && 0 <= ny && ny < M) {
								if (chk[nx][ny] == 0) {
									chk[nx][ny] = 1;
									if (map[nx][ny] == -1) {
										map[nx][ny] = landIdx;
										q.offer(new Pair(nx, ny));
									}
								}

							}
						}
					}
					landIdx++;
				}
			}
		}
//		2. 섬을 연결하기 위해 섬을 이루는 모든 점을 지도에서 찾아
//			다른 섬과의 거리를 구한다 (dfs 활용)
		island = new int[landIdx][landIdx];
		for (int[] ilnd : island) {
			Arrays.fill(ilnd, 999);
		}

		for (int landN = 1; landN < landIdx; landN++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == landN) {
						for (int dir = 0; dir < 4; dir++) {
							cnt = 0;
							dfs(i, j, landN, dir);
						}
					}
				}
			}
		}
		
//		3-1. 섬들을 연결하는 간선들 중 가장 짧은 간선을 선택한다. (프림 알고리즘 활용)
		int countLen = 0;
		islandParent = new int[landIdx];
		for (int i = 0; i < landIdx; i++) {
			islandParent[i] = i;
		}
		int connect1 = 0, connect2 = 0;
		while (true) {
			int lineLen = 999;
			for (int i = 1; i < landIdx; i++) {
				for (int j = i; j < landIdx; j++) {
					if (island[i][j] != 999 && lineLen > island[i][j]) {
						lineLen = island[i][j];
						connect1 = i;
						connect2 = j;
					}
				}
			}
			if(lineLen==999) break;
//			3-2. 연결하려는 두 섬이 서로 연결되어 있는지 확인한다.
//				   아직 연결되어 있지 않다면 연결한다. (UnionFind 활용)
			
			island[connect1][connect2]=999;
			if(find(connect1)==find(connect2))continue;
			else{
				countLen+=lineLen;
				if(find(connect1)>find(connect2)) {
					islandParent[find(connect1)]=find(connect2);
				}else {
					islandParent[find(connect2)]=find(connect1);
				}
			}
		}
//		3-3. 모든 섬이 연결되어있다면 총 거리의 합을 출력한다.
		for(int i=2;i<landIdx;i++) {
			if(find(islandParent[1])!=find(islandParent[i])) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(countLen);
	}

	private static int find(int c) {
		if(c==islandParent[c]) {
			return c;
		}
		return find(islandParent[c]);
	}

	static int nx, ny, cnt;

	private static void dfs(int x, int y, int landNum, int dir) {
		nx = x + dx[dir];
		ny = y + dy[dir];
		if (0 <= nx && nx < N && 0 <= ny && ny < M) {
			if (map[nx][ny] == landNum)
				return;
			if (map[nx][ny] == 0) {
				cnt++;
				dfs(nx, ny, landNum, dir);
			} else if (cnt >= 2 && island[landNum][map[nx][ny]] > cnt) {
				island[landNum][map[nx][ny]] = cnt;
				island[map[nx][ny]][landNum] = cnt;
			}
		}
	}
}
