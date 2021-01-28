package y2020.m09.d30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
풀이시간 : 10분
시간 : 84ms
메모리 : 13036KB
- topdown방식
- 점화식 연습 수준
*/
/*
9
 */
public class Main_bj_11727_2xn타일링2_topdown방식 {
	public static int memo[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N+2];
		memo[1]=1;
		memo[2]=3;
		int answer = dp(N);
		System.out.println(answer%10007);
	}

	private static int dp(int n) {
		if(n==1) {
			return 1;
		}else if(n==2) {
			return 3;
		}else {
			int a = 0;
			int b = 0;
			if(memo[n-1]!=0) {
				a=memo[n-1];
			}else {
				a=dp(n-1)%10007;
				memo[n-1]=a;
			}
			if(memo[n-2]!=0) {
				b=memo[n-2];
			}else {
				b=dp(n-2)%10007;
				memo[n-2]=b;
			}
			return a+b*2;
		}
	}
}
