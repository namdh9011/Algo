package y2020.m10.d19;

import java.util.*;
import java.io.*;
/*
풀이시간 : 
시간 : 
메모리 : 
- 
*/
/*
6 2
391123
//output : 9123

6 2
436436
//output : 6436

7 3
7654321
//output : 7654

6 2
362514
//output : 6514

6 4
198794

답 : 99
 */
public class Main_bj_2812_크게만들기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = N-K;
		String input = br.readLine();
		int endpoint = -1;
		stack.add(input.charAt(0)-'0');
		for(int i=1;i<N;i++) {
			if(count==N-i) {
				endpoint = i;
				break;
			}
			int com = stack.pop();
			int curr = input.charAt(i)-'0';
			if(count==0) {
				break;
			}
			if(com>=curr) {
				stack.add(com);
				stack.add(curr);
			}else {
				stack.add(curr);
				count--;
			}
		}
		Stack<Integer> q = new Stack<>();
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			q.add(curr);
		}
		while(!q.isEmpty()) {
			int curr = q.pop();
			sb.append(curr);
		}
		sb.append(input.substring(endpoint+1,N));
		System.out.println(sb.toString());
	}
}

