import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1233 {
	public static boolean isOperator(String str) {
		if (str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-")) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, res, nodes;
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			res = 1;
			if (N % 2 == 0) {
				res = 0;
				for(int i = 1; i <= N; i++) {
					br.readLine();
				}
			}
			if (res == 1) {
				for (int i = 1; i <= N; i++) {
					st = new StringTokenizer(br.readLine());
					nodes = st.countTokens();
					if (nodes == 4) {
						st.nextToken();
						if (!isOperator(st.nextToken())) {
							res = 0;
						}
						if (isOperator(st.nextToken())) {
							res = 0;
						}
						if (isOperator(st.nextToken())) {
							res = 0;
						}
					} else if (nodes == 3) {
						st.nextToken();
						if (!isOperator(st.nextToken())) {
							res = 0;
						}
						if (isOperator(st.nextToken())) {
							res = 0;
						}
					} else if (nodes == 2) {
						st.nextToken();
						if (isOperator(st.nextToken())) {
							res = 0;
						}
					}		
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
