import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Stack<int[]> stack = new Stack<>();
		int[] res = new int[N];

		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			while (!stack.empty()) {
				if (stack.peek()[1] >= num) {
					res[i-1] = stack.peek()[0];
					break;
				} else {
					stack.pop();
				}
			}
			if (stack.empty()) {
				res[i]=0;
			}
			stack.push(new int[] { i, num });
		}
		
		for(int r:res) {
			System.out.print(r+" ");
		}
	}
}
