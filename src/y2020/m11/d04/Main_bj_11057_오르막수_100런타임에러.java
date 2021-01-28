package y2020.m11.d04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
1
 */
public class Main_bj_11057_오르막수_100런타임에러 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][10];		
		for(int i=0;i<10;i++) {
			dp[0][i]=10-i;
			dp[1][0]+=dp[0][i];
		}
		for(int i=1;i<N-1;i++) {
			dp[i+1][0]=dp[i][0];
			for(int j=1;j<10;j++) {
				dp[i][j]=(dp[i][j-1]-dp[i-1][j-1]+10007)%10007;
				dp[i+1][0]+=dp[i][j];
			}
			if(dp[i+1][0]>10007) {
				dp[i+1][0]=dp[i+1][0]%10007;
			}
		}
		System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[N-1][0]);
	}
}
