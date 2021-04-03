import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main12865 {
	static int N, K;
	static int[] W, V, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N];
		V = new int[N];
		res = new int[K + 1];
		Arrays.fill(res, -1);
		res[0]=0; //초기값 설정 위해서.

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for(int j=K; j>=0;j--) {
//				기존에 저장된 값이 있고, 배낭에 넣을 수 있다면
				if(res[j]>=0 && j+W[i]<=K) {
					res[j+W[i]]=Integer.max(res[j+W[i]], res[j]+V[i]);
					max=Integer.max(max, res[j+W[i]]);
				}
			}
		}
		System.out.println(max);
	}
}
