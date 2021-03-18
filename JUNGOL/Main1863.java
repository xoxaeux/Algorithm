import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main1863 {
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int a, b;
		parents = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}
		int fa, fb;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			fa = find(a);
			fb = find(b);
			union(fa, fb);
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(find(parents[i]));
		}
		System.out.println(set.size());

	}

	private static int find(int num) {
		if (num == parents[num]) {
			return num;
		}
		return find(parents[num]);
	}

	private static void union(int fa, int fb) {
		// 서로의 뿌리가 다르면 합치면 됨.
		if (fa < fb) {
			parents[fb] = fa;
		} else if (fa > fb) {
			parents[fa] = fb;
		}
		// 뿌리 같으면 굳이 할 필요 없음.
	}
}
