import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1987 {
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int R,C;
    static char[][] map;
    static int[][] chk;
    static boolean[] visited;
    static int maxCnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        chk = new int[R][C];

        for(int i=0;i<R;i++){
            String strIn = br.readLine();
            for(int j=0;j<C;j++){
                map[i][j]=strIn.charAt(j);
            }
        }

        visited = new boolean[26]; // 'A':65 / 'Z':90
        execute(0,0,chk,visited,1);
        System.out.println(maxCnt);
    }

    static int nx,ny;
    static void execute(int x,int y,int[][] c,boolean[] v,int cnt){
        maxCnt = Math.max(maxCnt,cnt);
        c[x][y]=cnt;
        v[(int)map[x][y]-'A']=true;
        for(int i=0;i<4;i++){
            nx = x+dir[i][0];
            ny = y+dir[i][1];
            if(nx<0||nx>=R||ny<0||ny>=C) continue;
            if(v[(int)map[nx][ny]-'A'])continue;
            execute(nx,ny,c,v,cnt+1);
        }
    }
}
