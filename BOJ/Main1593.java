import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main1593{
	static int N,M,cnt=0;
	static boolean flag = true;
	static HashMap<Character, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 1. 찾아야할 값들을 문자별로 map에 저장하기.
		String strIn = br.readLine();
		for(int i=0;i<N;i++) {
			if(map.containsKey(strIn.charAt(i))) {
				map.put(strIn.charAt(i),map.get(strIn.charAt(i))+1);
			}else {
				map.put(strIn.charAt(i),1);
			}
		}
		// 2. 값을 찾으며, 찾아야하는 값들이 저장된 map의 모든 value가 0이 된다면 cnt 증가.
		// 2-1. 가장 처음 N만큼은 집어넣고, 끝에 확인만 하기.
		strIn = br.readLine();
		Queue<Character> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			q.offer(strIn.charAt(i));
			if(map.containsKey(strIn.charAt(i))) {
				map.put(strIn.charAt(i),map.get(strIn.charAt(i))-1);
			}
		}
		Iterator<Character> iter = map.keySet().iterator();
		
		while(iter.hasNext()) {
			if(map.get(iter.next())!=0) {
				flag = false;
				break;
			}
		}
		if(flag) cnt++;
		
		Character ch;
		for(int i=N;i<M;i++) {
			flag = true;
			// 2-2. 들어온 순서대로 하나씩 빼기.
			ch = q.poll();
			if(map.containsKey(ch))	map.put(ch,map.get(ch)+1);
			// 2-3. 하나씩 집어넣기.
			ch = strIn.charAt(i);
			q.offer(ch);
			if(map.containsKey(ch))	map.put(ch,map.get(ch)-1);
			// 2-4. 찾아야 하는 값 전부 0이라면, cnt 증가.
			iter = map.keySet().iterator();
			
			while(iter.hasNext()) {
				if(map.get(iter.next())!=0) {
					flag = false;
					break;
				}
			}
			
			if(flag) cnt++;
		}
		System.out.println(cnt);
	}
}
