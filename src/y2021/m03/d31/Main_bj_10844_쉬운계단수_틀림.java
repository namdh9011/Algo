package y2021.m03.d31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
- 틀림 다시풀어보기.
*/
/*
2
 */
public class Main_bj_10844_쉬운계단수_틀림 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		dp[1]=9;
		long t = 1;
		for(int i=2;i<=N;i++) {
			dp[i] = ((dp[i-1]*2) - t)%1000000000;
			t=(t*2)%1000000000;
		}
		System.out.println(dp[N]);
	}
}


