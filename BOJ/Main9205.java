import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9205 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		int n;
		int[][] points;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			points = new int[n + 2][2];
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}
//			입력 끝.
//			편의점 들르면 그 지점부터 1000미터 이동가능

			int now,dis;
			boolean[] chk = new boolean[n + 2];
//			chk[0] = true;
			Queue<Integer> q = new LinkedList<>();
			q.add(0);
			boolean flag=false;
			top:
			while (!q.isEmpty()) {
				now=q.poll();
				for (int i = 1; i < n + 2; i++) {
					if (chk[i])	continue;
					dis = Math.abs(points[now][0] - points[i][0]) +
							Math.abs(points[now][1] - points[i][1]);
					if (dis <= 1000) {
						if (i == n + 1) {
							flag=true;
							break top;
						}
						chk[i]=true;
						q.add(i);
					}
				}
			}
			if(flag) System.out.println("happy");
			else System.out.println("sad");

		} // tc
	}
}
