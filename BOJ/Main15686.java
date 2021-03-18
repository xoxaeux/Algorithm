import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main15686 {
	static int N, M;
	static int[][] house;
	static int[][] chicken;
	static int[][] comb;
	static int houseIdx;
	static int chickenIdx;
	static int distHouse;

	static int houseX, houseY, chicX, chicY, dist, total=Integer.MAX_VALUE;

	private static void combination(int idx, int start) {
		if (idx == M) {
			dist = 0;
			for (int i = 0, end = houseIdx; i < end; i++) {
				houseX = house[i][0];
				houseY = house[i][1];
				distHouse=Integer.MAX_VALUE;
				for (int j = 0; j < idx; j++) {
					chicX = comb[j][0];
					chicY = comb[j][1];
					distHouse = Integer.min(distHouse,Math.abs(houseX - chicX) + Math.abs(houseY - chicY));
				}
				dist+=distHouse;
			}
			total=Integer.min(dist,total);
			
			
			return;
		}
		for (int i = start; i < chickenIdx; i++) {
			comb[idx][0] = chicken[i][0];
			comb[idx][1] = chicken[i][1];

			combination(idx + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int num;
		house = new int[2 * N][2];
		houseIdx = 0;
		chicken = new int[13][2];
		chickenIdx = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					house[houseIdx][0] = i;
					house[houseIdx++][1] = j;
				} else if (num == 2) {
					chicken[chickenIdx][0] = i;
					chicken[chickenIdx++][1] = j;
				}
			}
		}
		
		comb=new int[M][2];
		combination(0, 0);
		System.out.println(total);
	}
}
