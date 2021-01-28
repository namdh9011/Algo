package y2020.m09.d08;

import java.util.Stack;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_2018카카오_N진수게임 {
	public static void main(String[] args) throws Exception {
		int n=2;
		int t=4;
		int m=2;
		int p=1;
		System.out.println(solution(n,t,m,p));
	}
	
	public static String solution(int n, int t, int m, int p) {
        String answer = "";
        String out = "0";
        for(int i=1;i<t*m+1;i++) {
        	String a = change(i,n);
        	out+=a;
        }
        for(int i=0;i<t;i++) {
        	answer+=out.charAt(i*m+p-1);
        }
        return answer;
    }

	private static String change(int num, int n) {
		Stack<String> st = new Stack<>();
		while(num>1) {
			if(num%n>9) {
				char c =(char)(num%n-10+'A');
				String s = c+"";
				st.add(s);
				num/=n;
			}else {
				String s = Integer.toString(num%n);
				st.add(s);
				num/=n;
			}
		}
		String output = "";
		if(num==1) {
			output = Integer.toString(num);
		}
		while(!st.isEmpty()) {
			output+=st.pop();
		}
		return output;
	}
}
