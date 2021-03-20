import java.util.Arrays;
import java.util.Scanner;

public class Main15649 {
	static int N;
	static int R;
	static int[] numbers; // 순열을 저장하는 배열
	static boolean[] selected; // 원소 중복 여부를 알려주는 상태배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		selected = new boolean[N + 1];
		permutation(0);
	}

	private static void permutation(int idx) {
		if (idx == R) {
			for (int n : numbers) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (selected[i])
				continue;

			numbers[idx] = i;
			selected[i] = true;
			permutation(idx + 1);
			selected[i] = false;

		}
	}
}
