import java.util.*;

public class Main14503 {
	static int[][] map;
	static int N;
	static int M;
	static int D;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		int R=sc.nextInt();
		int C=sc.nextInt();
		D=sc.nextInt();//북동남서 
		map = new int[N][M];
		for(int i=0; i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		execute(R,C);
		int cnt=0;
		for(int i=0; i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==2) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	//청소한 공간 -> 2
	private static void execute(int x, int y) {
//		1.현재 위치를 청소한다.
		map[x][y]=2;
//		2.현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
		int nx,ny;
		for(int i=0;i<4;i++) {
			D--;
			if(D==-1)D=3;
//			2-a.왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
//			2-b.왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
			nx=x+dx[D];
			ny=y+dy[D];
			if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0) {
				execute(nx,ny);
				return;
			}
		}
//		2-c.네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
//		2-d.네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
		nx=x-dx[D];
		ny=y-dy[D];
		if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=1) {
			execute(nx,ny);
			return;
		}
		return;

		
		
	}
}
