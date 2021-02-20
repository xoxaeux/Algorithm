import java.util.Scanner;
public class Main1038 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N <= 10) {
			System.out.println(N);
			return;
		}
		int num = 20;
		int cnt = 10;
		char[] numChar;
		int past;
		boolean flag;
		while (true) {
			flag = true;
			if (cnt == N) {
				System.out.println(num);
				return;
			}
			numChar = Integer.toString(num).toCharArray();
			for (char c :numChar) {
				System.out.print(c+" ");
			}
			System.out.println();
			past = numChar[0];
			for (int i = 1; i < numChar.length; i++) {
				if (past <= numChar[i]) {
					System.out.println(past+" "+numChar[i]);
					num=change(numChar,i);
					flag = false;
					break;
				}
				past = numChar[i];
			}
			if (flag == true) {
				cnt++;
				num++;
			}
		}

	}
	/**
	 * 된다면, 하나증가 / 안된다면 안된자리를 0으로 이전에 1증가 (아래는 예시)
	 * 99(X) -> 100 -> 110 -> 200 -> 210 -> 211(X) -> 220 -> 300 -> 310
	 */
	private static int change(char[] numChar, int idx) {
		System.out.println("___");
		String numStr = null;
		for(int i=0;i<idx;i++) {
			numStr+=numChar[i];
		}
		int res = Integer.parseInt(numStr)+1;
		for(int i=idx;i<numChar.length;i++) {
			res*=10;
		}
		return res;
	}
}
