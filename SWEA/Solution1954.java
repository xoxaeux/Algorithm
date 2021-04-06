import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution1954 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int[][] nums;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int num = Integer.parseInt(br.readLine());
 
            System.out.println("#" + tc);
            if (num == 1) {
                System.out.println(1);
            } else {
                snail(num);
            }
        }
    }
 
    private static void snail(int num) {
        nums = new int[num][num];
        int limit = num * num;
        int x = 0, y = 0, i = 0;
        for (int n = 1; n <= limit; n++) {
            nums[x][y] = n;
            if ((x == 0 && y == num - 1) || (x == num - 1 && y == num - 1) || (x == num - 1 && y == 0))
                i++;
            if (nums[x + dx[i]][y + dy[i]] != 0)
                i++;
            if (i == 4)
                i = 0;
            x += dx[i];
            y += dy[i];
        }
        for (int k = 0; k < num; k++) {
            for (int j = 0; j < num; j++) {
                System.out.print(nums[k][j] + " ");
            }
            System.out.println();
        }
    }
}
