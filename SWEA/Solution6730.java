import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6730 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T= Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			int pre=Integer.parseInt(st.nextToken());
			int cur;
			int max=0,min=0;
			for (int i=1;i<N;i++) {
				cur=Integer.parseInt(st.nextToken());
				if (pre<cur) {
					max=Integer.max(max, cur-pre);
				}else {
					min=Integer.max(min, pre-cur);
				}
				pre=cur;
			}
			System.out.println("#"+tc+" "+max+" "+min);
		}
	}
}
