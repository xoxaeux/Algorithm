import java.util.Arrays;
import java.util.Scanner;

public class Main11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		for(int i=0;i<N;i++) {
			nums[i]=sc.nextInt();
		}
		Arrays.sort(nums);
		int sum=0;
		for(int i=0;i<N;i++) {
			sum+=nums[i]*(N-i);
		}
		System.out.println(sum);
	}
}
