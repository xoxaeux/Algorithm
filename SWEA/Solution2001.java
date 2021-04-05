import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution2001{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n, m;
        int[][] map;
        int sum,res;
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            res=0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][n];
 
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i <= n - m; i++) {
                for (int j = 0; j <= n - m; j++) {
                    sum = 0;
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < m; l++) {
                            sum += map[i+k][j+l];
                        }
                    }
                    if(sum>res) {
                        res=sum;
                    }
                }
            }
            System.out.printf("#"+tc+" "+res);
            System.out.println();
        }
    }
}
