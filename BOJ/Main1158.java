import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> q = new LinkedList();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		int num, cnt = 0, idx = 0;
		int[] nums = new int[N];

		while (!q.isEmpty()) {
			num = q.poll();
			cnt++;
			if (cnt == K) {
				nums[idx] = num;
				idx++;
				cnt = 0;
			} else {
				q.add(num);
			}
		}
		System.out.print("<");
		for (int i=0;i< nums.length-1;i++) {
			System.out.print(nums[i]+", ");
		}
		System.out.print(nums[nums.length-1]+">");
	}
}
