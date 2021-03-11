package y2021.m03.d11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
10
10 -4 11 1 8 6 -35 12 21 -1
 */

class Main_bj_1912_연속합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[N+1];
		for(int i=1;i<=N;i++) {
			dp[i]=Integer.parseInt(st.nextToken());
		}
		
		int max = dp[1];
		for(int i=2;i<=N;i++) {
			if(dp[i-1]>0 && dp[i] + dp[i-1]>0) {
				dp[i]+=dp[i-1];
			}
			if(max<dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}