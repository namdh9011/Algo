package y2020.m10.d16;

import java.util.*;
import java.io.*;
/*
풀이시간 : 10분
시간 : 100ms
메모리 : 13328KB
- 
*/
/*
4
1 5 6 7
 */
public class Main_bj_16194_카드구매하기2 {
	public static int cost[],dp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		cost = new int[N+1];
		dp = new int[N+1];
		for(int i=1;i<=N;i++) {
			cost[i]=Integer.parseInt(st.nextToken());
		}
		dp[1]=cost[1];
		for(int i=1;i<=N;i++) {
			int min = cost[i];
			for(int j=1;j<=i/2;j++) {
				if(dp[j]+dp[i-j]<min) {
					min = dp[j]+dp[i-j];
				}
			}
			dp[i]=min;
		}
		System.out.println(dp[N]);
	}
}
