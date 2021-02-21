import java.util.Arrays;
import java.util.Scanner;

public class Main1038 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N <= 10) {
			System.out.println(N);
			return;
		}
		if(N>1022) {
			System.out.println(-1);
			return;
		}
		int num = 20;
		int cnt = 11;
		char[] numChar;
		int past;
		boolean flag;
		while (true) {
			flag = true;
			if(cnt == 1022) {
				System.out.println("9876543210");
				return;
			}
			
			numChar = Integer.toString(num).toCharArray();
			past = numChar[0];
			for (int i = 1; i < numChar.length; i++) {
				if (past <= numChar[i]) {
					num=change(num,i,numChar.length);
					flag = false;
					break;
				}
				past = numChar[i];
			}
			if (flag == true) {
				if (cnt == N) {
					System.out.println(num);
					return;
				}
				cnt++;
				num++;
			}
		}

	}
	/**
	 * 된다면, 하나증가 / 안된다면 안된자리를 0으로 이전에 1증가 (아래는 예시)
	 * 99(X) -> 100 -> 110 -> 200 -> 210 -> 211(X) -> 220 -> 300 -> 310
	 */
	private static int change(int num, int idx,int len) {
		int res=num/(int)Math.pow(10, len-idx);
		res++;
		for(int i=idx;i<len;i++) {
			res*=10;
		}
		return res;
	}
}
