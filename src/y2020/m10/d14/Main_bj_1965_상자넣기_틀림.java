package y2020.m10.d14;

import java.util.*;
import java.io.*;
/*
8
1 6 2 5 7 3 5 6
 */
public class Main_bj_1965_상자넣기_틀림 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[N];
		
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(input));
		
		int[] dp = new int[N+1];
		for(int i=0;i<dp.length;i++) {
			dp[i]=Integer.MAX_VALUE;
		}
		int index = 1;
		dp[0]=input[0];
		for(int i=1;i<N;i++) {
			int curr = input[i];
			int temp = index;
			for(int j=0;j<temp;j++) {
				if(dp[j]>curr) {
					dp[j]=curr;
					break;
				}
				if(j==temp-1&&curr>dp[j]) {
					dp[index]=curr;
					index++;
				}
			}
			System.out.println(index);
			System.out.println(Arrays.toString(dp));
		}
		System.out.println(index);
	}
}
