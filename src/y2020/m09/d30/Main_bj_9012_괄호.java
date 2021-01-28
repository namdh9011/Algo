package y2020.m09.d30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
풀이시간 : 10분
시간 : 80ms
메모리 : 13140KB
- Stack 연습
*/
/*
6
(())())
(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())()(
 */
public class Main_bj_9012_괄호 {
	public static int top;
	public static char stack[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		stack = new char[51];
		top = -1;
		for(int i=0;i<T;i++) {
			char arr[] = br.readLine().toCharArray();
			for(int j=0;j<arr.length;j++) {
				char temp = arr[j];
				if(temp=='(') {
					push(temp);
				}else if(temp==')') {
					char c = pop();
					if(c=='*') {
						top = -2;
						break;
					}
				}
			}
			if(top==-1) {
				sb.append("YES").append("\n");
			}else {
				sb.append("NO").append("\n");
			}
			top=-1;
		}
		System.out.println(sb.toString());
	}
	private static char pop() {
		char ch = 0;
		if(top==-1) {
			return '*';
		}else {
			ch = stack[top];
			top--;
		}
		return ch;
	}
	private static void push(char ch) {
		top++;
		stack[top] = ch;
	}
}
