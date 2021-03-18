import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution1289 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            String in = br.readLine();
            int sol = 0;
            for (int i = 0; i < in.length(); i++) {
                if (i == 0 && in.charAt(i) == '1') {
                    sol++;
                } else if (i != 0 && in.charAt(i - 1) != in.charAt(i)) {
                    sol++;
                }
            }
            System.out.println("#" + tc + " " + sol);
        }
    }
 
}
