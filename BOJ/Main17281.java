import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main17281 {
	static int[][] map;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		map=new int [N][9];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
//		9명 순서정해서 돌려보는 순열완탐.
		perm[3]=0;
		chk[0]=true;
		permutation(0);
		System.out.println(maxScore);
	}
	
	static int[] perm = new int[9];
	static boolean[] chk = new boolean[9];
	static int score,maxScore;
	static int outCnt,now;
	static boolean[] roo;
//	타순정하기 -> 정해진 타순에 맞춰 점수 도출하기.
	private static void permutation(int idx) {
		if(idx == 9) {
			score=0;
			now=0;
			for(int i=0;i<N;i++) {
				roo = new boolean[3];	//이닝마다 roo 초기화.
				outCnt=0;
				while(outCnt<3) {
					scoreCal(map[i][perm[now]]);
					now++;
					if(now==9)now=0;
				}
			}
			
			if(maxScore==0)		maxScore=score;
			else if(maxScore<score)		maxScore=score;
			return;
		}
		if(idx==3) {
			permutation(4);
			return;
		}
		for(int i=0;i<9;i++) {
		
			if(!chk[i]) {
				chk[i]=true;
				perm[idx]=i;
				permutation(idx+1);
				chk[i]=false;
			}
		}
	}
	
//	X루타에 맞춰 점수 계산하는 함수
	private static void scoreCal(int X) {
		switch(X) {
		case 0:
			outCnt++;
			break;
		case 1:
			if(roo[2])score++;
			roo[2]=roo[1];
			roo[1]=roo[0];
			roo[0]=true;
			break;
		case 2:
			if(roo[2])score++;
			if(roo[1])score++;
			roo[2]=roo[0];
			roo[1]=true;
			roo[0]=false;
			break;
		case 3:
			if(roo[2])score++;
			if(roo[1])score++;
			if(roo[0])score++;
			roo[2]=true;
			roo[1]=false;
			roo[0]=false;
			break;
		case 4:
			if(roo[2])score++;
			if(roo[1])score++;
			if(roo[0])score++;
			score++;
			roo[2]=false;
			roo[1]=false;
			roo[0]=false;
			break;
		}
	}
}
