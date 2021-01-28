package y2020.m09.d30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
풀이시간 : 10분
시간 : 1544ms
메모리 : 338548KB
- topdown + 메모이제이션 방식
- 점화식 연습 수준
*/
/*
3
4
7
10
 */
public class Main_bj_9095_123더하기3_topdownmemo방식 {
	
	public static long memo[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			int n = Integer.parseInt(br.readLine());
			memo = new long[n+3];
			memo[1]=1;
			memo[2]=2;
			memo[3]=4;
			dp(n);
			sb.append(memo[n]%1000000009).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static long dp(int n) {
		if(n==1) {
			return 1;
		}else if(n==2) {
			return 2;
		}else if(n==3) {
			return 4;
		}else {
			long a = 0;
			long b = 0;
			long c = 0;
			
			if(memo[n-1]!=0) {
				a = memo[n-1];
			}else {
				a = dp(n-1);
				memo[n-1]=a%1000000009;
			}
			if(memo[n-2]!=0) {
				b = memo[n-2];
			}else {
				b = dp(n-2);
				memo[n-2]=b%1000000009;
			}
			if(memo[n-3]!=0) {
				c = memo[n-3];
			}else {
				c = dp(n-3);
				memo[n-3]=c%1000000009;
			}
			
			long ans = a%1000000009 + b%1000000009 + c%1000000009;
			memo[n]=ans;
			return ans;
		}
	}
}
