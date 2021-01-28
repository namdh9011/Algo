package y2020.m09.d29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
풀이시간 : 
시간 : 132ms
메모리 : 15980KB
- 출력이 많을때는 StringBuilder쓰면 좋음
*/
/*
14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top
 */
public class Main_bj_10828_스택 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] stack = new int[10000];
		int top = -1;
		for(int i=0;i<N;i++) {
			String[] curr = br.readLine().split(" ");
			String command = curr[0];
			if(command.equals("push")) {
				top++;
				stack[top] = Integer.parseInt(curr[1]);
			}else if(command.equals("pop")) {
				if(top==-1) {
					sb.append(-1).append("\n");
				}else {
					sb.append(stack[top]).append("\n");
					top--;
				}
			}else if(command.equals("size")) {
				sb.append(top+1).append("\n");
			}else if(command.equals("empty")) {
				if(top==-1) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}else if(command.equals("top")) {
				if(top==-1) {
					sb.append(-1).append("\n");
				}else {
					sb.append(stack[top]).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
