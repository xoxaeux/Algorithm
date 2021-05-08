import java.util.*;

class Solution_p2 {
	static boolean[] chk;
	static boolean flag;
	static int cnt;
	static int cntMax=0;
	
    public static int solution(int[][] needs, int r) {
        int answer = 0;
        chk = new boolean[needs.length];
        combination(needs,needs.length,needs[0].length,r,0,0);
        answer=cntMax;
        return answer;
    }
    
    public static void combination(int[][] needs,int n,int m, int r, int idx, int start) {
		if(idx == r) {
			System.out.println(Arrays.toString(chk));
			cnt=0;
			for(int i=0;i<n;i++) {
				flag = false;
				for(int j=0;j<m;j++) {
					if(!chk[j] && needs[i][j]==1) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					cnt++;
				}
			}
			if(cntMax<cnt) {
				cntMax=cnt;
			}
			return;
		}
		
		for (int i = start; i <n; i++) {
			chk[i] = true;
			combination(needs,n,m,r,idx+1,i+1);
			chk[i] = false;
		}
	}
    
    public static void main(String[] args) {
    	int[][] g = {{1,0,0},{1,1,0},{1,1,0},{1,0,1},{1,1,0},{0,1,1}};
    
		System.out.println(solution(g,2));
		/**
1 0 0
1 1 0
1 1 0
1 0 1
1 1 0
0 1 1
		 */
		
	}
}