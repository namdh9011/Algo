package y2021.m04.d15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
메모리 : 11700KB
시간 : 84ms

최적 메모리 : 12940KB
최적 시간 : 68ms
*/
/*
10 3
1 2 3
 */
public class Main_bj_1021_회전하는큐 {
	public static Deque<Integer> dq;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		dq = new LinkedList<>();
		for(int i=0;i<N;i++) {
			dq.add(i+1);
		}
		st = new StringTokenizer(br.readLine());
		int count = 0;
		for(int i=0;i<M;i++) {
			int tar = Integer.parseInt(st.nextToken());
			count += solve(tar);
		}
		System.out.println(count);
	}

	private static int solve(int tar) {
		int size = dq.size();
		int left = 0;
		for(int i=0;i<size;i++) {
			int curr = dq.pollFirst();
			if(curr==tar) {
				left=i;
			}
			dq.addLast(curr);
		}
		int right = 0;
		for(int i=1;i<=size;i++) {
			int curr = dq.pollLast();
			if(curr==tar) {
				right=i;
			}
			dq.addFirst(curr);
		}
		if(left<right) {
			for(int i=0;i<size;i++) {
				int curr = dq.pollFirst();
				if(curr==tar) {
					break;
				}
				dq.addLast(curr);
			}
			return left;
		}else {
			for(int i=0;i<size;i++) {
				int curr = dq.pollLast();
				if(curr==tar) {
					break;
				}
				dq.addFirst(curr);
			}
			return right;
		}
	}
}