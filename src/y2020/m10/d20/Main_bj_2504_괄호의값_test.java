package y2020.m10.d20;

import java.util.*;
import java.io.*;
/*
풀이시간 : 60분 + 60분
시간 : 76ms
메모리 : 12988KB
- 60분내에 못풀었음
- invalid 먼저 판별하는 방법 스터디를 통해 알아내고 60분내에 해결
*/
/*
(()[[]])([])
 */
public class Main_bj_2504_괄호의값_test {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		if(invalid(input)) {
			System.out.println(0);
		}else {
			System.out.println(solve(input,0,input.length()));
		}
	}
	public static int solve(String input, int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		int result = 0;
		Stack<Character> stack = new Stack<>();
		for(int i=start;i<end;i++) {
			char curr = input.charAt(i);
			if(stack.size()==0) {
				q.add(i);
				if(curr=='(') {
					stack.add(curr);
				}else if(curr=='['){
					stack.add(curr);
				}
			}else {
				char com = stack.peek();
				if(com=='(') {
					if(curr=='(') {
						stack.add(curr);
					}else if(curr==')') {
						stack.pop();
						if(stack.size()==0) {
							q.add(i);
						}
					}else if(curr=='[') {
						stack.add(curr);
					}
				}else if(com=='[') {
					if(curr=='(') {
						stack.add(curr);
					}else if(curr=='[') {
						stack.add(curr);
					}else if(curr==']'){
						stack.pop();
						if(stack.size()==0) {
							q.add(i);
						}
					}
				}
			}
		}
		while(!q.isEmpty()) {
			int starta = q.poll();
			int enda = q.poll();
			if(enda-starta==1) {
				if(input.charAt(starta)=='(') {
					result+=2;
				}else {
					result+=3;
				}
			}else {
				int temp = solve(input,starta+1,enda);
				if(input.charAt(starta)=='(') {
					result+=2*temp;
				}else {
					result+=3*temp;
				}
			}
		}
		return result;
	}
	public static boolean invalid(String input) {
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<input.length();i++) {
			char curr = input.charAt(i);
			if(stack.size()==0) {
				if(curr=='(') {
					stack.add(curr);
				}else if(curr=='['){
					stack.add(curr);
				}else {
					return true;
				}
			}else {
				char com = stack.peek();
				if(com=='(') {
					if(curr=='(') {
						stack.add(curr);
					}else if(curr==')') {
						stack.pop();
					}else if(curr=='[') {
						stack.add(curr);
					}else if(curr==']'){
						return true;
					}
				}else if(com=='[') {
					if(curr=='(') {
						stack.add(curr);
					}else if(curr==')') {
						return true;
					}else if(curr=='[') {
						stack.add(curr);
					}else if(curr==']'){
						stack.pop();
					}
				}
			}
		}
		if(stack.size()!=0) {
			return true;
		}
		return false;
	}
}

