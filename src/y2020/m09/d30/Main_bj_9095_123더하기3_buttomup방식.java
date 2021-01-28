package y2020.m09.d30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
풀이시간 : 10분
시간 : 844ms
메모리 : 290492KB
- topdown방식
- 점화식 연습 수준
*/
/*
3
4
7
10
 */
public class Main_bj_9095_123더하기3_buttomup방식 {
	
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
			if(n>3) {
				for(int i=4;i<=n;i++) {
					memo[i]=memo[i-1]%1000000009+memo[i-2]%1000000009+memo[i-3]%1000000009;
				}
			}
			sb.append(memo[n]%1000000009).append("\n");
		}
		System.out.println(sb.toString());
	}
}
