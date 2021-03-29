import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12871 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		String shorter,longer;
		if(s.length()<t.length()) {
			shorter=s;
			longer=t;
		}else {
			shorter=t;
			longer=s;
		}
		
		boolean flag=true;
		int chkLength = longer.length()*2;
		for(int i=0,j=0,k=0;i<chkLength;i++) {
			if(j==shorter.length()) {
				j=0;
			}
			if(k==longer.length()) {
				k=0;
			}			
			if(shorter.charAt(j)!=(longer.charAt(k))) {
				flag=false;
				break;
			}
			j++;
			k++;
		}
		System.out.println(flag?1:0);		
	}
}
