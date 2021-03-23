import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1149 {
	static int N;
	static int[] rgb;
	static int[] sol;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		rgb = new int[3]; //현재 RGB값
		sol = new int[3]; //현재 해당색을 색칠하기 위한 cost최솟값
		
//		sol에 초기값설정
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int j=0;j<3;j++) {
			sol[j]=Integer.parseInt(st.nextToken());
		}
		
//		입력과 동시에 계산하기.
		int costR, costG, costB;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgb[j] = Integer.parseInt(st.nextToken());
			}
			costR = rgb[0]+Integer.min(sol[1],sol[2]);
			costG = rgb[1]+Integer.min(sol[0],sol[2]);
			costB = rgb[2]+Integer.min(sol[0],sol[1]);
			sol[0]=costR;
			sol[1]=costG;
			sol[2]=costB;
		}
		
		System.out.println(Integer.min(Integer.min(sol[0], sol[1]),sol[2]));
		

	}
}
