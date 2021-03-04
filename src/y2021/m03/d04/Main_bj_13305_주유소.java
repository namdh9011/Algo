package y2021.m03.d04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4
2 3 1
5 2 4 1
 */


class Main_bj_13305_주유소 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] cost = new long[N];
		long[] dist = new long[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++) {
			dist[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			cost[i]=Integer.parseInt(st.nextToken());
		}
		long answer = cost[0]*dist[0];
		long min = cost[0];
		for(int i=1;i<N-1;i++) {
			if(min>cost[i]) {
				min=cost[i];
			}
			answer+=min*dist[i];
		}
		System.out.println(answer);
	}
}