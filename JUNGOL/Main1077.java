import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main1077 {
	static int N,W;
	static int[] weight, price;
	static int max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		weight = new int[N];
		price = new int[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			weight[i]=Integer.parseInt(st.nextToken());
			price[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] res = new int[W+1];
		for (int i=1;i<=W;i++) {
			for (int j=0;j<N;j++) {
				if(i>=weight[j]) {
					res[i]=Integer.max(res[i-weight[j]]+price[j],res[i]);
					max=Integer.max(max, res[i]);
				}
			}
		}
		System.out.println(Arrays.toString(res));
		System.out.println(max);
		
		
	}
}
