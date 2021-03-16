import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1759 {
	static String[] strIn;
	static int L, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		strIn = new String[C];
		for (int i = 0; i < C; i++) {
			strIn[i] = st.nextToken();
		}
		Arrays.sort(strIn);
		Combination(0);
	}

	static String[] comb = new String[L];

	private static void Combination(int idx) {
		if (idx == L) {
			for (String c : comb) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}
		for (int i = idx; i < C; i++) {
			comb[i] = strIn[i];
			Combination(i + 1);
		}
	}

}
