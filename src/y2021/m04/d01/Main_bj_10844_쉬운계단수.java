package y2021.m04.d01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
- 답보고 풂
*/
/*
2
 */
public class Main_bj_10844_쉬운계단수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N+1][10];
		for(int i=1;i<10;i++) {
			dp[1][i]=1;
		}
		for(int i=2;i<=N;i++) {
			for(int j=0;j<10;j++) {
				if(j==0) {
					dp[i][j]=dp[i-1][j+1]%1000000000;
				}else if(j==9) {
					dp[i][j]=dp[i-1][j-1]%1000000000;
				}else {
					dp[i][j]=dp[i-1][j+1]+dp[i-1][j-1]%1000000000;
				}
			}
		}
		long answer = 0;
		for(int i=0;i<10;i++) {
			answer+=dp[N][i];
		}
		System.out.println(answer%1000000000);
	}
}


