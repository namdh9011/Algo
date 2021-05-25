package y2021.m05.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
메모리 : 13400KB
시간 : 104ms

최적 메모리 : 22884KB
최적 시간 : 184ms
//BFS로 풀려고 시간낭비를 많이함...
*/
/*
2
3 3
1 2
2 3
1 3
5 4
2 1
2 3
4 3
4 5
 */
public class Main_bj_9372_상근이의여행 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			for(int i=0;i<M;i++) {
				br.readLine();
			}
			sb.append(N-1).append("\n");
		}
		System.out.println(sb.toString());
	}
}


