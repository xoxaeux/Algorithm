import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();

//		T의 맨 뒷자리를 보고 이전의 것을 생각해보자.
		String temp;
		while (S.length() < T.length()) {
			if (T.charAt(T.length() - 1) == 'A') {
				T = T.substring(0, T.length() - 1);
			} else {
				temp=T.substring(0, T.length() - 1);
				T="";
				for(int i=temp.length()-1;i>=0;i--) {
					T+=temp.charAt(i);
				}
			}
			System.out.println(T);
		}

		if (S.equals(T)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
/*
A
BA
*/