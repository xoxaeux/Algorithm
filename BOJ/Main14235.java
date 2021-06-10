import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
		public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		int a;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			if(a==0) {
				if(q.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(q.poll());
				}
			}else {
				for(int j=0;j<a;j++) {
					q.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}
	}
}
