import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1037 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] col = new int[N];
		int[] row = new int[N];
		int numIn;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				numIn = sc.nextInt();
				col[i] += numIn;
				row[j] += numIn;
			}
		}
		int[] res = new int[2];
		for (int i = 0; i < N; i++) {
			if (col[i] % 2 != 0) {
				if (res[0] != 0) {
					System.out.println("Corrupt");
					return;
				}
				res[0] = i + 1;
			}
			if (row[i] % 2 != 0) {
				if (res[1] != 0) {
					System.out.println("Corrupt");
					return;
				}
				res[1] = i + 1;
			}
		}
		if (res[0] == 0 && res[1] == 0) {
			System.out.println("OK");
			return;
		} else {
			System.out.println("Change bit (" + res[0] + "," + res[1] + ")");
		}
	}
}