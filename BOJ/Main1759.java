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
	static String[] comb;

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
		comb = new String[L];
		Combination(0, 0);
	}

	private static void Combination(int idx, int start) {
		if (idx == L) {
			boolean flag=false;
			int cnt=0;
			for (int i = 0; i < L; i++) {
				if(cnt>=2&&flag) {
					break;
				}
				if (comb[i].equals("a") || comb[i].equals("e") || comb[i].equals("i") || comb[i].equals("o")
						|| comb[i].equals("u")) {
					flag = true;
				}else {
					cnt++;
				}
			}
			if (cnt>=2&&flag) {
				for (String c : comb) {
					System.out.print(c);
				}
				System.out.println();
			}
			return;
		}
		for (int i = start; i < C; i++) {
			comb[idx] = strIn[i];
			Combination(idx + 1, i + 1);
		}
	}
}
