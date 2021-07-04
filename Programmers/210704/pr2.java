import java.util.*;
class pr2 {
    public String[] solution(String s) {
        String[] answer;
        Queue<String> q = new LinkedList<>();
        int sIdx=0, fIdx=s.length();
        int len = 1;
        boolean flag = true;
        
        while(true) {
        	if(s.substring(sIdx, sIdx+len).equals(s.substring(fIdx-len,fIdx))) {
        		q.offer(s.substring(sIdx, sIdx+len));
        		sIdx = sIdx+len;
        		fIdx = fIdx-len;
        		len = 1;
        		if(fIdx == sIdx) {
        			flag = false;
        			break;
        		}
        	}
        	else {
        		len++;
        	}
        	if(sIdx+len-1 >= fIdx-len) {
        		if(flag) {
        			q.offer(s.substring(sIdx, fIdx));
        		}
        		break;
        	}
        	
        }
        
        if(flag) {
        	answer = new String[(q.size()*2)-1];
        }else {
        	answer = new String[q.size()*2];        	
        }
        
        int idx=0;
        int nIdx = q.size();
        //우선 앞에 하나씩 집어넣기.
        while(!q.isEmpty()) {
        	answer[idx++] = q.poll();
        }
        
        if(flag) nIdx-=2;
        else nIdx--;
        
        for(int i=idx;i<answer.length;i++) {
        	answer[i] = answer[nIdx--];
        }
        return answer;
    }
}