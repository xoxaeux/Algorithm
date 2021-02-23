import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main2605 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		List<Integer> nums = new ArrayList<>();
		nums.add(1);
		sc.nextInt();	// 한 개 소모하기
		
		for (int i=2;i<=N;i++) {
			int num = sc.nextInt();
			nums.add(nums.size()-num, i);
		}
		Iterator<Integer> iter=nums.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next()+" ");
		}
		
	}
}
