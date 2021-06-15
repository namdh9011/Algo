package y2021.m06.d04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
메모리 : 11908 KB
시간 : 84 ms

최적 메모리 : 12836 KB
최적 시간 : 72 ms
*/
/*
5
3 1 4 3 2
 */
public class Main_bj_11399_ATM {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int sum = arr[0];
		int[] dp = new int[N+1];
		dp[0]=arr[0];
		for(int i=1;i<N;i++) {
			dp[i]=dp[i-1]+arr[i];
			sum+=dp[i];
		}
		System.out.println(sum);
	}
}


