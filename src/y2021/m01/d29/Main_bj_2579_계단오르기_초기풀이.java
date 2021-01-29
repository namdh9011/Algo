package y2021.m01.d29;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
6
10
20
15
25
10
20
 */


class Main_bj_2579_계단오르기_초기풀이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N+3];
		int[][] dp = new int[N+3][2];
		for(int i=0;i<N;i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		dp[1][0]=0;
		dp[1][1]=stairs[0];
		dp[2][0]=stairs[0]+stairs[1];
		dp[2][1]=stairs[1];
		dp[3][0]=stairs[1]+stairs[2];
		dp[3][1]=stairs[0]+stairs[2];
		for(int i=4;i<=N;i++) {
			dp[i][0]=dp[i-1][1]+stairs[i-1];
			dp[i][1]=Integer.max(dp[i-2][0], dp[i-2][1])+stairs[i-1];
		}
		if(N==1) {
			System.out.println(stairs[0]);
		}else {
			System.out.println(Integer.max(dp[N][0], dp[N][1]));
		}
	}
}