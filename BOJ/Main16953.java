import java.util.*;
public class Main16953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int cnt=1;
		while(A<B) {
			cnt++;
			if(B%10==1) {
				B=B/10;
			}else if(B%2==0){
				B=B/2;
			}else {
				System.out.println(-1);
				return;
			}
		}
		if(A==B) {
			System.out.println(cnt);
		}else {
			System.out.println(-1);
		}
		
	}
}
