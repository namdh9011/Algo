package y2021.m03.d06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
2
6
100
 */


class Main_bj_9461_파도반수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[N+6];
			dp[0]=1;
			dp[1]=1;
			dp[2]=1;
			dp[3]=2;
			dp[4]=2;
			for(int i=5;i<N;i++) {
				dp[i]=dp[i-1]+dp[i-5];
			}
			sb.append(dp[N-1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}