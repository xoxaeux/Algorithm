//import java.util.*;
//class Solution {
//	static String[] nums= {"zero","one","two","three","four","five","six","seven","eight","nine"};
//    public static int solution(String s) {
//        String answer ="";
//        int idx=0;
//        int maxIdx=s.length();
//        
////        String[] numString = s.split("");
//        int ascii;
//        boolean flag;
//        while(idx<maxIdx) {
//        	ascii = (int) s.charAt(idx);
//        	if(ascii>=48 && ascii<=57){ //숫자일 경우
//        		answer+=s.charAt(idx);
//        		idx++;
//        	}else {	//문자일 경우
//        		for(int i=0;i<=9;i++) { //1부터 9까지 검사할 것이고,
//        			flag = true;
//        			for(int j=0;j<nums[i].length();j++) { //숫자 영단어의 길이만큼
//        				if(s.length()<=(idx+j) || s.charAt(idx+j) != nums[i].charAt(j)) {
//        					flag = false;
//        					break;
//        				}
//        			}
//        			if(flag) { //일치하는 경우.
//        				answer+=String.valueOf(i);
//        				idx+=nums[i].length();
//        			}
//        		}
//        	}
//        }
//        return Integer.parseInt(answer);
//    }
//    
//    public static void main(String[] args) {
//		System.out.println(solution("one4seveneight"));
//
//	}
//}
import java.util.*;
class Solution1 {
	static String[] nums= {"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static int solution(String s) {
        String answer ="";
        int idx=0;
        int maxIdx=s.length();
        
        int ascii;
        boolean flag;
        while(idx<maxIdx) {
        	ascii = (int) s.charAt(idx);
        	if(ascii>=48 && ascii<=57){ //숫자일 경우
        		answer+=s.charAt(idx);
        		idx++;
        	}else {	//문자일 경우
        		for(int i=0;i<=9;i++) { //1부터 9까지 검사할 것이고,
        			flag = true;
        			for(int j=0;j<nums[i].length();j++) { //숫자 영단어의 길이만큼
        				if(s.length()<=(idx+j) || s.charAt(idx+j) != nums[i].charAt(j)) {
        					flag = false;
        					break;
        				}
        			}
        			if(flag) { //일치하는 경우.
        				answer+=String.valueOf(i);
        				idx+=nums[i].length();
        			}
        		}
        	}
        }
        return Integer.parseInt(answer);
    }
}