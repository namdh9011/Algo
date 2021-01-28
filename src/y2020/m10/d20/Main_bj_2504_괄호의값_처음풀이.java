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
public class Main_bj_2504_괄호의값_처음풀이 {
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
		int[] se = new int[50];
		int index= 0 ;
		int result = 0;
		Stack<Character> stack = new Stack<>();
		for(int i=start;i<end;i++) {
			char curr = input.charAt(i);
			if(stack.size()==0) {
				se[index]=i;
				index++;
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
							se[index]=i;
							index++;
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
							se[index]=i;
							index++;
						}
					}
				}
			}
		}
		se[index]=-1;
		for(int i=0;i<se.length;i=i+2) {
			if(se[i]==-1) {
				break;
			}
			if(se[i+1]-se[i]==1) {
				if(input.charAt(se[i])=='(') {
					result+=2;
				}else {
					result+=3;
				}
			}else {
				if(input.charAt(se[i])=='(') {
					result+=2*solve(input,se[i]+1,se[i+1]);
				}else {
					result+=3*solve(input,se[i]+1,se[i+1]);
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
		return false;
	}
}

