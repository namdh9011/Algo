package y2021.m03.d31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
메모리 : 12104KB
시간 : 116ms

최적 메모리 : 13396KB
최적 시간 : 84ms

- 풀이 보고 풀었음.
*/
/*
7
 */
public class Main_bj_1699_제곱수의합_풀이보고풂 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		for(int i=1;i<=N;i++) {
			dp[i] = i;		//1의 제곱으로만 수를 나타냈을때
			for(int j=1;j*j<=i;j++) {
				if(dp[i]>dp[i-j*j]+1) {	//제곱 할 수 있는 수를 빼고 +1 했을때 가 더 작을경우
					dp[i]=dp[i-j*j]+1;
				}
			}
		}
		System.out.println(dp[N]);
	}
}


