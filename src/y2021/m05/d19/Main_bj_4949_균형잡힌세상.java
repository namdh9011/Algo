package y2021.m05.d19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
/*
메모리 : 16436KB
시간 : 168ms

최적 메모리 : 15228KB
최적 시간 : 96ms
*/
/*
So when I die (the [first] I will see in (heaven) is a score list).
[ first in ] ( first out ).
Half Moon tonight (At least it is better than no Moon at all].
A rope may form )( a trail in a maze.
Help( I[m being held prisoner in a fortune cookie factory)].
([ (([( [ ] ) ( ) (( ))] )) ]).
 .
.
 */
public class Main_bj_4949_균형잡힌세상 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		StringBuilder sb = new StringBuilder();
		while((s = br.readLine()).charAt(0)!='.') {
			if(solve(s)) {
				sb.append("yes\n");
			}else {
				sb.append("no\n");
			}
		}
		System.out.println(sb.toString());
	}
	public static boolean solve(String s) {
		int n = s.length();
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<n;i++) {
			char curr = s.charAt(i);
			if(curr=='('||curr=='[') {
				stack.add(curr);
			}else if(curr==')') {
				if(stack.size()==0||stack.pop()!='(') {
					return false;
				}
			}else if(curr==']') {
				if(stack.size()==0||stack.pop()!='[') {
					return false;
				}
			}
		}
		if(stack.size()!=0) {
			return false;
		}
		return true;
	}
}


