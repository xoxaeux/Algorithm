import java.util.Arrays;
import java.util.Scanner;

public class Main12907 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int idx1=0,idx2=0;
		int[] nums = new int[N];
		boolean flag=true;
		for(int i=0;i<N;i++) {
			nums[i]=sc.nextInt();
		}
		Arrays.sort(nums);
		for(int i=0;i<N;i++) {
			if(idx1==nums[i]) {
				idx1++;
			}else if(idx2==nums[i]) {
				idx2++;
			}else {
				flag=false;
				break;
			}
		}

		int num;
		if(!flag) {
			num=0;
		}else {
			if(idx2==0){
				num=2;
			}else {
				num=(int)Math.pow(2, idx2);
				if(idx1 > idx2) {
					num*=2;
				}
			}
		}
		System.out.println(num);
//		0 1 2 3/ 0 1 2-> 4,3  : 2*(idx2)*(idx1-idx2)
	}
}
