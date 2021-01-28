package y2020.m09.d30;
import java.io.*;
/*
풀이시간 : 60분
시간 : 276ms
메모리 : 27324KB
- Stack 연습
- while문에서 br.readLine()할 때 마지막 값 벗어나는 것 처리하는데 애먹음
- 스택 범위 벗어나는것 잘 처리 해줘야됨.
*/
/*
8
4
3
6
8
7
5
2
1
 */

public class Main_bj_1874_스택수열 {

	public static int top, stack[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		stack = new int[N+1];
		top = -1;
		int count = 0;
		int curr = Integer.parseInt(br.readLine());
		count++;
		for(int i=1;i<=N;i++) {
			push(i);
			sb.append("+").append("\n");
			while(peek()==curr) {
				pop();
				sb.append("-").append("\n");
				if(count==N) {
					break;
				}
				curr = Integer.parseInt(br.readLine());
				count++;
			}
		}
		
		if(top==-1) {
			System.out.println(sb.toString());
		}else {
			System.out.println("NO");
		}
	}
	
	
	private static int peek() {
		if(top<0) {
			return -2;
		}
		return stack[top];
	}
	private static int pop() {
		if(top<0) {
			return -1;
		}else {
			int a = stack[top];
			top--;
			return a;
		}
	}
	private static void push(int num) {
		top++;
		stack[top] = num;
	}
}
