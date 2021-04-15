import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main15961 {
	static int N, D, K, C;
	static int maxCnt;
	
	static int[] InitFoods;
	static int[] chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		InitFoods= new int[K];
		Queue<Integer> q = new LinkedList<>();	//처음것을빼고 마지막에넣기위한 큐
		chk= new int[D+1];	//숫자가 D까지 등장하므로 D+1까지 생성.
		/*
		 * K개는 마지막과 이어지니 따로 저장해두기.
		 * K개를 뽑으면서, chk에 체크해두며 카운트. 이미 1이상이라면, cnt올라가지 않음
		 * K개를 뽑은 후에는 처음것을 빼고(chk에서 1감소), 뽑힌수 chk+1하기.
		 * 쿠폰 C의 숫자가 chk에서 0이라면 cnt+1하고, maxCnt 갱신.
		 */
		int num, cnt=0;
		for(int i=0;i<K;i++) {
			num=Integer.parseInt(br.readLine());
			//처음 K개는 회전초밥 마지막과 이어지므로 저장해두기.
			InitFoods[i]=num;
			q.offer(num);
			if(chk[num]<1) cnt++;
			chk[num]++;
		}
		
		if(chk[C]==0) {	//쿠폰 숫자확인.
			maxCnt=cnt+1;
		}else {
			maxCnt=cnt;
		}
		
		maxCnt=cnt;
		
		int pickNum;
		for(int i=K;i<N;i++) {
			num=Integer.parseInt(br.readLine()); //들어갈 숫자
			q.offer(num);
			chk[num]++;
			if(chk[num]==1) {
				cnt++;
			}
			
			pickNum = q.poll(); //뽑은 숫자
			chk[pickNum]--;
			if(chk[pickNum]==0) {
				cnt--;
			}
			
			if(chk[C]==0) {	//쿠폰 숫자확인.
				maxCnt=Math.max(cnt+1, maxCnt);
			}else {
				maxCnt=Math.max(cnt, maxCnt);
			}
			
			
		}
		
//		마지막엔 처음에 있었던 숫자들을 순서대로 넣어준다 (회전)
		for(int i=0;i<K;i++) {
			num=InitFoods[i];//들어갈 숫자 (큐에 넣어줄 필요는 없음)
			chk[num]++;
			if(chk[num]==1) {
				cnt++;
			}
			
			pickNum = q.poll(); //뽑은 숫자
			chk[pickNum]--;
			if(chk[pickNum]==0) {
				cnt--;
			}
			
			if(chk[C]==0) {	//쿠폰 숫자확인.
				maxCnt=Math.max(cnt+1, maxCnt);
			}else {
				maxCnt=Math.max(cnt, maxCnt);
			}
		}
		System.out.println(maxCnt);
	}
}
