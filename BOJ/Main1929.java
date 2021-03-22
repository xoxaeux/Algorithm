import java.util.Scanner;

public class Main1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		makeAns(M, N);
	}

	static boolean[] numList;
	static int num = 2;

	private static void makeAns(int a, int b) {
		numList = new boolean[b + 1];
		numList[0]=true;
		numList[1]=true;

		while (num <= Math.sqrt(b)) {
			for (int i = num; i < b + 1; i++) {
				if (num * i > b) {
					break;
				}
				numList[num * i] = true;

			}
			for (int i = num+1; i < b + 1; i++) {
				if (!numList[i]) {
					num = i;
					break;
				}
			}
		}
		for (int i = a; i <= b; i++) {
			if (!numList[i]) {
				System.out.println(i);
			}
		}
	}
}
