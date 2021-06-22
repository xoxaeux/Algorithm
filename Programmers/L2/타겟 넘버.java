import java.util.*;
class Solution {
    static Queue<Integer> q = new LinkedList<>();
    static int qIdx,qNum;
    public int solution(int[] numbers, int target) {
        int answer = 0;

        q.offer(numbers[0]);
        q.offer(-numbers[0]);

        for(int num=1;num<numbers.length-1;num++){
            qIdx = q.size();
            for(int i=0;i< qIdx;i++){
                qNum = q.poll();
                q.offer(qNum + numbers[num]);
                q.offer(qNum - numbers[num]);
            }
        }
        while(!q.isEmpty()){
            qNum = q.poll();
            if(qNum + numbers[numbers.length-1] == target) answer++;
            if(qNum - numbers[numbers.length-1] == target) answer++;
        }

        return answer;
    }
}
