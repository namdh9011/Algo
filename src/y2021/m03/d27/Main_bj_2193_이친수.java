package y2021.m03.d27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
메모리 : 11512KB
시간 : 76ms

최적 메모리 : 12844KB
최적 시간 : 68ms

- N이 90까지 이므로 int범위 벗어남.
*/

/*
3
 */
public class Main_bj_2193_이친수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+2];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<N;i++) {
			dp[i]=dp[i-2]+dp[i-1];
		}
		System.out.println(dp[N-1]);
	}
}
