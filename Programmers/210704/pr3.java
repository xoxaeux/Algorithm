import java.util.*;

public class pr3 {
    public  int solution(String s, String t) {
        int result =0;
        int idx=0;
        int len = t.length();
        while(true) {
        	if(s.length()<len || s.length()<idx+len) break;
        	if(s.substring(idx, idx+len).equals(t)) {
        		result++;
        		s = s.substring(0,idx)+s.substring(idx+len,s.length());
        		// ã�� �ȴٸ�, ã�� index-1���� �ٽ� ���� �ȴ�.
        		idx-=2;
        	}
        	idx++;
        	if(idx<0)idx=0;
        }
        return result;
    }
}