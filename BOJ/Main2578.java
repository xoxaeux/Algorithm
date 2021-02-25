import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2578 {
	static int[][] nums = new int[5][5];
	static int[][] chk = new int[5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int num;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				num = Integer.parseInt(st.nextToken());
				if(isBingo(num)) {
					System.out.println(i*5+(j+1));
					return;
				}
			}
		}
	}

	private static boolean isBingo(int num) {
		int cnt=0;
		top:
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if (nums[i][j]==num) {
					chk[i][j]=1;
					break top;
				}
			}	
		}
		boolean flag=false;
		for(int i=0;i<5;i++) { //가로 검사
			flag=true;
			for(int j=0;j<5;j++) {
				if(chk[i][j]==0) {
					flag=false;
					break;
				}
			}
			if(flag==true) {
				cnt++;
			}
		}
		for(int j=0;j<5;j++) { //세로 검사
			flag=true;
			for(int i=0;i<5;i++) {
				if(chk[i][j]==0) {
					flag=false;
					break;
				}
			}
			if(flag==true) {
				cnt++;
			}
		}
		
		boolean flagB=true;
		flag=true;
		for (int i=0;i<5;i++) { 
			if(chk[i][i]==0) {// 대각선1 검사
				flag=false;
			}
			if(chk[i][4-i]==0) {// 대각선2 검사
				flagB=false;
			}
		}
		if(flag==true)	cnt++;
		if(flagB==true)	cnt++;
		
		if(cnt>=3) {
			return true;
		}
		return false;
	}
}
