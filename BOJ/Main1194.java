import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main1194 {
	static int N,M;
	static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
	static String[][] map;
	static boolean[][][] chk;
	
	static class Pair{
		int x,y,key;
		Pair(int x,int y,int key){
			this.x=x;
			this.y=y;
			this.key=key;
		}
	}
	
	static Queue<Pair> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new String[N][M];
		chk = new boolean[N][M][1<<7]; //7개로 저장. 아무 키도 없을 때 chk위함.
		String[] strIn;
		int x = 0,y = 0;
		for(int i=0;i<N;i++) {
			strIn=br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j]=strIn[j];
				if(map[i][j].equals("0")) {
					x=i;
					y=j;
					map[i][j]=".";
				}
			}
		}
		chk[x][y][0]=true;
		q.offer(new Pair(x,y,1));
		bfs();
		System.out.println(cnt);
	}
	
	static Pair p;
	static int nx,ny;
	static int cnt=0;
	private static void bfs() {
		while(!q.isEmpty()) {
			cnt++;
			int qSize = q.size();
			int qIdx=0;
			while(qIdx<qSize) {
				p=q.poll();
				for(int i=0;i<4;i++) {
					nx=p.x+dir[i][0];
					ny=p.y+dir[i][1];
					if (nx < 0||nx >= N||ny < 0||ny >= M)	continue;
					if (chk[nx][ny][p.key])	continue;
					if (map[nx][ny].equals("1")) {
						return;
					}
					execute(nx,ny,map[nx][ny],p.key);
				}
				qIdx++;
			}			
		}
		cnt=-1;
	}
	
	private static void execute(int x,int y,String s, int key) {
		if(s.equals("#"))	return;
		
		else if(s.equals("A") && (key&1<<1)==0) return;
		else if(s.equals("B") && (key&1<<2)==0) return;
		else if(s.equals("C") && (key&1<<3)==0) return;
		else if(s.equals("D") && (key&1<<4)==0) return;
		else if(s.equals("E") && (key&1<<5)==0) return;
		else if(s.equals("F") && (key&1<<6)==0) return;
		
		else if(s.equals("a"))	key |= 1<<1;
		else if(s.equals("b"))	key |= 1<<2;
		else if(s.equals("c"))	key |= 1<<3;
		else if(s.equals("d"))	key |= 1<<4;
		else if(s.equals("e"))	key |= 1<<5;
		else if(s.equals("f"))	key |= 1<<6;
		
		chk[nx][ny][key] = true;
		q.offer(new Pair(nx,ny,key));
		return;
	}
}
