import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3289 {
	static int[] nums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int N, M;
		int x, a, b;
		String sol = null;
		
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			nums = new int[N + 1];
			for(int i=1;i<=N;i++) {
				nums[i]=i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(a>b) {
					int temp = a;
					a= b;
					b= temp;
				}
				if(x==0) {
					union(a,b);
				}else {
					int fa = find(a);
					int fb = find(b);
					if(fa!=fb) {
						sb.append("0");
					}else {
						sb.append("1");
					}
				}
			}
			String s= sb.toString();
			System.out.println("#"+tc+" "+s);
		}
	}

	private static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa>fb) {
			nums[fa]=fb;
		}if(fa<fb) {
			nums[fb]=fa;
		}
	}

	private static int find(int i) {
//		타고 올라가면서 가장 끝 부모찾는 함수.
		if(nums[i]==i) {
			return i;
		}
		return find(nums[i]);
	}

}
