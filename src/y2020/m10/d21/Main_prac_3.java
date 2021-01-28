package y2020.m10.d21;

import java.util.*;
import java.io.*;
/*
풀이시간 : 
시간 : 
메모리 : 
- 
*/
public class Main_prac_3 {
	public static int answer;
	public static void main(String[] args) throws Exception{
		String s = "";
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<500000;i++) {
			if(s.length()>500000) {
				break;
			}
			sb.append(Integer.toString(i));
		}
		s = sb.toString();
		System.out.println(s.charAt(0));
		System.out.println(solution(s));
	}
	public static int solution(String s) {
		answer = 0;
		for(int len=1;len<=5;len++) {
			for(int i=0;i<s.length()-len+1;i++) {
				if(len<2||s.charAt(i)!='0') {
					int a = solve(s,s.substring(i,i+len),i+len);
					if(a>len&&answer<a) {
						answer = a;
					}
				}
			}
		}
		return answer;
	}
	public static int solve(String s, String sub, int start) {
		int curr = Integer.parseInt(sub);
		int len = sub.length();
		int result = len;
		if(s.length()-start<answer) {
			return 0;
		}
		for(int i=start;i<s.length();i=i+len) {
			if(curr==9||curr==99||curr==999||curr==9999) {
				len++;
			}else if(curr==99999) {
				return result;
			}
			if(i+len>s.length()) {
				return result;
			}
			curr++;
			int temp = Integer.parseInt(s.substring(i,i+len));
			if(temp==curr) {
				result+=len;
			}else {
				return result;
			}
		}
		return result;
	}
}