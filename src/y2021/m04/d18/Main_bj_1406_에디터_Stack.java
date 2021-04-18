package y2021.m04.d18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/*
메모리 : 147200KB
시간 : 820ms

최적 메모리 : 49560KB
최적 시간 : 312ms
- 스택 힌트 받음.
- 노드 쓰는 풀이 있는듯.
*/
/*
abcd
3
P x
L
P y
 */
public class Main_bj_1406_에디터_Stack {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> front = new Stack<>();
		Stack<Character> back = new Stack<>();
		for(int i=0;i<s.length();i++) {
			front.push(s.charAt(i));
		}
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			char command = st.nextToken().charAt(0);
			if(command=='L') {
				if(front.size()>0) {
					back.push(front.pop());
				}
			}else if(command=='D') {
				if(back.size()>0) {
					front.push(back.pop());
				}
			}else if(command=='B') {
				if(front.size()>0) {
					front.pop();
				}
			}else {
				char word = st.nextToken().charAt(0);
				front.push(word);
			}
		}
		while(!front.isEmpty()) {
			back.add(front.pop());
		}
		StringBuilder sb = new StringBuilder();
		while(!back.isEmpty()) {
			sb.append(back.pop());
		}
		System.out.println(sb.toString());
	}
}