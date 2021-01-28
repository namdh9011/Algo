package y2020.m10.d20;

import java.util.*;
import java.io.*;
/*
풀이시간 : 60분 + 60분
시간 : 76ms
메모리 : 12988KB
- 60분내에 못풀었음
- invalid 먼저 판별하는 방법 스터디를 통해 알아내고 60분내에 해결
- 리팩토링 
- 배열대신 q 사용;
- invalid 먼저 판별하지 않고 풀이
- 잔조건이 많아지고 시간이 늘어남
*/
/*
(()[[]])([])
 */
public class Main_bj_2504_괄호의값 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(solve(input,0,input.length(),false));
	}
	public static int solve(String input, int start, int end, boolean flag) {
		if(flag) {
			return 0;
		}
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
				}else {
					flag = true;
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
					}else if(curr==']'){
						flag = true;
					}
				}else if(com=='[') {
					if(curr=='(') {
						stack.add(curr);
					}else if(curr==')') {
						flag = true;
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
		if(stack.size()>0||q.size()%2==1) {
			flag=true;
			return 0;
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
				int temp = solve(input,starta+1,enda,flag);
				if(input.charAt(starta)=='(') {
					result+=2*temp;
				}else {
					result+=3*temp;
				}
			}
		}
		if(flag) {
			result=0;
		}
		return result;
	}
}