import java.util.*;

public class Main1755 {
	public static class numNword implements Comparable<numNword>{
		int num;
		String word;
		public numNword(int num,String word) {
			this.num = num;
			this.word = word;
		}
		public int compareTo(numNword n) {	
			return this.word.compareTo(n.word);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		String[] numToWord = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		PriorityQueue<numNword> q = new PriorityQueue<>();
		
		String numWord;
		for(int num=M;num<=N;num++) {
			numWord="";
			if(num/10>0) {
				numWord+=numToWord[num/10];
			}
			numWord+=numToWord[num%10];
			q.offer(new numNword(num,numWord));
		}
		
		int cnt=0;
		while(!q.isEmpty()) {
			System.out.print(q.poll().num);
			cnt++;
			if(cnt==10) {
				cnt=0;
				System.out.println();
			} else {
				System.out.print(" ");
			}
		}
	}
}
