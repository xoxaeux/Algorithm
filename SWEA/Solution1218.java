import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution1218 {
    public static void main(String[] args) throws NumberFormatException, IOException {
//      '()', '[]', '{}', '<>'
        int num, res;
        String strIn;
        Stack<String> stack;
        String[] strSplit;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for (int tc = 1; tc <= 10; tc++) {
            res=1;
            num = Integer.parseInt(br.readLine());
            strIn = br.readLine();
            strSplit = strIn.split("");
            stack = new Stack<>();
            for (int i = 0; i < num; i++) {
                if (strSplit[i].equals("(") || strSplit[i].equals("<") || strSplit[i].equals("{") || strSplit[i].equals("[")) {
                    stack.push(strSplit[i]);
                } else if (strSplit[i].equals("}")) {
                    if (stack.empty() || stack.peek().equals("{")) {
                        stack.pop();
                    } else {
                        res = 0;
                        break;
                    }
                } else if (strSplit[i].equals("]")) {
                    if (stack.empty() || stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        res = 0;
                        break;
                    }
                } else if (strSplit[i].equals(">")) {
                    if (stack.empty() || stack.peek().equals("<")) {
                        stack.pop();
                    } else {
                        res = 0;
                        break;
                    }
                } else if (strSplit[i].equals(")")) {
                    if (stack.empty() || stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        res = 0;
                        break;
                    }
                }
            }
            if(!stack.empty()) {
                res=0;
            }
            stack.clear();
            System.out.println("#" + tc + " " + res);
        }
    }
}
