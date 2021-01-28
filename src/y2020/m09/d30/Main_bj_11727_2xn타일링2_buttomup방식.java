package y2020.m09.d30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
풀이시간 : 10분
시간 : 76ms
메모리 : 12984KB
- buttom-up 방식
- 점화식 연습 수준
*/
/*
9
 */
public class Main_bj_11727_2xn타일링2_buttomup방식 {
	public static int memo[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N+2];
		memo[1]=1;
		memo[2]=3;
		if(N>2) {
			for(int i=3;i<=N;i++) {
				memo[i]=memo[i-1]%10007+(memo[i-2]*2)%10007;
			}
		}
		System.out.println(memo[N]%10007);
	}
}
