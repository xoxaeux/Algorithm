import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2477 {
	static int[] minusNums;
	static void solMinus(int n1,int n2) {
		if(n1+n2==1) { //0과 1이라면,
			minusNums[0]=3;
			minusNums[1]=4;
		} else if(n1+n2==3) { //1,2
			minusNums[0]=4;
			minusNums[1]=5;
		}else if(n1+n2==5 && n1!=0 && n2!=0) { //2,3
			minusNums[0]=5;
			minusNums[1]=0;
		}else if(n1+n2==7) { //3,4
			minusNums[0]=0;
			minusNums[1]=1;
		}else if(n1+n2==9) { //4,5
			minusNums[0]=1;
			minusNums[1]=2;
		}else if(n1+n2==5) { //5,0
			minusNums[0]=2;
			minusNums[1]=3;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] nums=new int[6][2];
		int max12 = 0,max34 = 0; // 1과 2중 최대와 3과 4중 최대
		int idx12 = 0,idx34 = 0;
		for ( int i=0;i<6;i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			//큰 거 두개와 인접한 변 제외 나머지 두 변으로 이루어진 사각형 넓이 빼기.
			if (dir ==1 || dir==2) {
				if (len>max12) {
					max12 = len;
					idx12 = i;
				}
			}else {
				if (len>max34) {
					max34 = len;
					idx34 = i;
				}
			}
			nums[i][0]=dir;
			nums[i][1]=len;
		}
		minusNums=new int[2];
		solMinus(idx12,idx34);
		int ans = K * ((max12 * max34) - (nums[minusNums[0]][1] *nums[minusNums[1]][1]));
		System.out.println(ans);
	}
}
