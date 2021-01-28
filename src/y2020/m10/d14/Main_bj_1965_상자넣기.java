package y2020.m10.d14;

import java.util.*;
import java.io.*;
/*
4
2 1 4 2
 */
public class Main_bj_1965_상자넣기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[N];
		
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		for(int i=0;i<dp.length;i++) {
			dp[i]=1;
		}
		
		for(int i=0;i<N;i++) {
			int curr = input[i];
			for(int j=0;j<i;j++) {
				if(input[j]<curr) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}
}
