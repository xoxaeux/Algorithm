import java.util.*;

class pr1 {
	public static int solution(int[] prices, int[] discounts) {
		int answer = 0;
		Arrays.sort(prices);
		Arrays.sort(discounts);

		int couponIdx = discounts.length - 1;
		for (int i = prices.length - 1; i >= 0; i--) {
			if (couponIdx < 0) {
				answer += prices[i];
			} else {
				answer += prices[i] * (100 - discounts[couponIdx--]) / 100;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] prices = { 13000, 88000, 10000, 100000, 2000, 30 };
		int[] dis = { 50, 80, 30, 20 };
		System.out.println(solution(prices, dis));

//		String s="abcdef";
//		String s = "llttaattll";
//		String s = "zzzzzz";
//		for(String sd : solution(s)) {
//			System.out.print(sd+" ");
	}
}