package y2021.m04.d01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
메모리 : 11896KB
시간 : 104ms

최적 메모리 : 12924KB
최적 시간 : 72ms
*/
/*
6
10 20 10 30 20 50
 */
public class Main_bj_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[N+1];
		dp[1]=1;
		int answer = 1;
		for(int i=2;i<=N;i++) {
			dp[i]=1;
			for(int j=1;j<=i;j++) {
				if(arr[j]<arr[i]) {
					dp[i]=Math.max(dp[i],dp[j]+1);
					if(dp[i]>answer) {
						answer = dp[i];
					}
				}
			}
		}
		System.out.println(answer);
	}
}


