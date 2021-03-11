import java.util.Scanner;

public class Main1810 {
	static Scanner sc = new Scanner(System.in);
	static int[] nums = new int[9];
	static int sum;
	static int[] comb = new int[7];
	public static void main(String[] args) {
		for (int i = 0; i < 9; i++) {
			nums[i] = sc.nextInt();
		}
		combination(0, 0);
	}

	private static void combination(int idx, int start) {
		if (idx == 7) {
			for (int i = 0; i < comb.length; i++) {
				sum += comb[i];
			}
			if (sum == 100) {
				for (int c : comb) {
					System.out.println(c);
				}
			} else {
				sum = 0;
			}
			return;
		}

		for (int i = start; i <= 8; i++) {
			comb[idx] = nums[i];
			combination(idx + 1, i + 1);
		}

	}

}
