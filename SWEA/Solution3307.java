import java.util.Arrays;
import java.util.Scanner;

public class Solution3307 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		int N;
		int[] nums,cnts;
		int num,cnt,cntMax;
		
		for(int tc=1;tc<=T;tc++) {
			N = sc.nextInt();
			nums = new int[N];
			cnts = new int[N];
			
//			모두 각자는 뽑고 시작함.
			Arrays.fill(cnts, 1);
			cntMax=1;
			for (int i=0;i<N;i++) {
				nums[i]=sc.nextInt();
			}
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if(nums[i]<nums[j]) {
						if(cnts[i]+1>cnts[j]) {
							cnts[j]=cnts[i]+1;
							if(cntMax<cnts[j]) {
								cntMax=cnts[j];
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+cntMax);
		}
	}
}
