import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main17135 {
	static class Pair implements Comparable<Pair> {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		int getDir(int y,int x) {
			return Math.abs(this.y - y) + Math.abs(x-this.x);
		}
		@Override
		// 거리가 같다면 가장 왼쪽것을 찾기 위함.
		public int compareTo(Pair p) {
			return p.y - this.y;
		}		
	}

	// 0540
	static int N, M, D;
	static int[][] map;
	static boolean[][] attacked;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					pq.offer(new Pair(i, j));
				}
			}
		}
		while (!pq.isEmpty()) {
			qArray.add(pq.poll());
		}
		chk = new boolean[M];
		combination(0, 0);
		System.out.println(maxCnt);
	}

	static int[] comb = new int[3];
	static boolean[] chk;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();
	static ArrayList<Pair> qArray = new ArrayList<>();
	static Pair[] picked;
	static Iterator<Pair> iter;
	static Pair p;
	static int dir,cnt,maxCnt=0;

	private static void combination(int idx, int start) {
		if (idx == 3) {
			attacked = new boolean[N][M];
			for (int round = N; round >0; round--) {
				picked = new Pair[3];
				for (int i = 0; i < 3; i++) {
					iter = qArray.iterator();
					dir = Integer.MAX_VALUE;
					while (iter.hasNext()) {
						p = iter.next();
						// x좌표가 round 진행한만큼 올라가므로 계산해준다.
						if(p.x>=round) continue;
						// q에 이미 죽인 적이라면 스킵.
						if(attacked[p.x][p.y]) continue;
						if(D<p.getDir(comb[i], round) || dir<p.getDir(comb[i], round)) continue;
						dir = p.getDir(comb[i],round);
						picked[i]=p;
					}
				}
				for(int i=0;i<3;i++) {
					if(picked[i]==null) continue;
					attacked[picked[i].x][picked[i].y]=true;
				}
			}
			cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(attacked[i][j]) cnt++;
				}
			}
			maxCnt=Integer.max(cnt, maxCnt);
			return;
		}
		for (int i = start; i < M; i++) {
			comb[idx] = i;
			chk[i] = true;
			combination(idx + 1, i + 1);
			chk[i] = false;
		}
	}
}