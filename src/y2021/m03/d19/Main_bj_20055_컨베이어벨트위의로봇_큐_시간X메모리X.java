package y2021.m03.d19;

import java.util.*;
import java.io.*;
/*
3 2
1 2 1 2 1 2
 */
public class Main_bj_20055_컨베이어벨트위의로봇_큐_시간X메모리X {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] a = new int[N*2];
		boolean[] robots = new boolean[N*2];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N*2;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		int up = 0;
		int down = N-1;
		Queue<Integer> q = new LinkedList<>();
		int step = 0;
		while(K>0) {
			step++;
			up=(up+(2*N)-1)%(2*N);
			down=(down+(2*N)-1)%(2*N);
			if(robots[down]) {
				robots[down]=false;
			}
			int size = q.size();
			if(size>0) {
				for(int i=0;i<size;i++) {
					int curr = q.poll();
					if(robots[curr]) {
						int next = (curr+1)%(2*N);
						if(!robots[next]&&a[next]>0) {
							robots[next]=true;
							robots[curr]=false;
							a[next]--;
							if(next==down) {
								robots[next]=false;
							}else {
								q.add(next);
							}
						}else {
							q.add(curr);
						}
					}
				}
			}
			if(!robots[up]&&a[up]>0) {
				q.add(up);
				robots[up]=true;
				a[up]--;
			}
			int count=0;
			for(int i=0;i<2*N;i++) {
				if(a[i]==0) {
					count++;
				}
			}
			if(count>=K) {
				break;
			}
		}
		System.out.println(step);
	}
}
