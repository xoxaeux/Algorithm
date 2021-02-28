import java.util.Arrays;
import java.util.Scanner;

public class Main3040 {
	static int[] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nums = new int[9];
		for (int i = 0; i < 9; i++) {
			nums[i] = sc.nextInt();
		}
		comb(0,0);
	}
	
	static boolean[] chk=new boolean[9];
	static int[] numsComb=new int[7];
	public static void comb(int idx,int start) {
		if (idx==7) {
			int sum=0;
			for(int j=0;j<7;j++) {
				sum+=numsComb[j];
			}
			if (sum==100) {
				for(int e: numsComb) {
					System.out.println(e);
				}
			}
			return;
		}
		for (int i = start; i <= 8; i++) {
			numsComb[idx] = nums[i];
			comb(idx + 1, i + 1);
		}
	}
}
