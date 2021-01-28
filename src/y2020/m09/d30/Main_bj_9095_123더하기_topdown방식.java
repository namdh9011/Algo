package y2020.m09.d30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
풀이시간 : 10분
시간 : 76ms
메모리 : 12960KB
- topdown방식
- 점화식 연습 수준
*/
/*
3
4
7
10
 */
public class Main_bj_9095_123더하기_topdown방식 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			int n = Integer.parseInt(br.readLine());
			int answer = dp(n);
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static int dp(int n) {
		if(n==1) {
			return 1;
		}else if(n==2) {
			return 2;
		}else if(n==3) {
			return 4;
		}else {
			return dp(n-1) + dp(n-2) + dp(n-3);
		}
	}
}
