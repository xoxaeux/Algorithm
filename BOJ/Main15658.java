import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15658 {
	static int N;
	static int[] nums;
	static int[] opers;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		opers = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			opers[i] = Integer.parseInt(st.nextToken());
			if (opers[i] > 10) {
				opers[i] = 10;
			}
		}

		permutation(1,nums[0]);
		
		System.out.println(max);
		System.out.println(min);

	}

	private static void permutation(int idx, int num) {
		if (idx == N) {
			if(num<min) {
				min=num;
			}
			if(num>max) {
				max=num;
			}
			return;
		}
		
		for(int j=0;j<4;j++) {
			if(j==0 && opers[j]>0) {
				opers[j]--;
				permutation(idx+1,num+nums[idx]);
				opers[j]++;
			}else if(j==1 && opers[j]>0) {
				opers[j]--;
				permutation(idx+1,num-nums[idx]);
				opers[j]++;
			}else if(j==2 && opers[j]>0) {
				opers[j]--;
				permutation(idx+1,num*nums[idx]);
				opers[j]++;
			}else if(j==3 && opers[j]>0) {
				opers[j]--;
				permutation(idx+1,num/nums[idx]);
				opers[j]++;
			}
		}
	}
}