package y2021.m02.d05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
6
6
10
13
9
8
1
 */


class Main_bj_2156_포도주시식 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] drink = new int[N+3];
		int[] dp = new int[N+3];
		for(int i=0;i<N;i++) {
			drink[i]=Integer.parseInt(br.readLine());
		}
		dp[0]=drink[0];
		dp[1]=drink[0]+drink[1];
		dp[2]=Math.max(dp[1], Math.max(dp[0]+drink[2], drink[1]+drink[2]));
		for(int i=3;i<N;i++) {
			dp[i]=Math.max(dp[i-1], Math.max(dp[i-2]+drink[i], dp[i-3]+drink[i-1]+drink[i]));
		}
		System.out.println(dp[N-1]);
	}
}