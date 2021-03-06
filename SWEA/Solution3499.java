import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int num, size1, size2;
		String[] arr1, arr2, in;
		for (int tc = 1; tc <= T; tc++) {
			num = Integer.parseInt(br.readLine());
			if (num % 2 == 1) {
				size1 = (num / 2) + 1;
			} else {
				size1 = num / 2;
			}
			size2 = num / 2;

			arr1 = new String[size1];
			arr2 = new String[size2];
			in = br.readLine().split(" ");
			for (int i = 0; i < num; i++) {
				if (i < size1) {
					arr1[i] = in[i];
				} else {
					arr2[i - size1] = in[i];
				}
			}
			System.out.print("#"+tc+" ");
			for (int i = 0; i < size1; i++) {
				System.out.print(arr1[i] + " ");
				if (i<size2) {
					System.out.print(arr2[i] + " ");
				}
			}
			System.out.println();
		}
	}
}
