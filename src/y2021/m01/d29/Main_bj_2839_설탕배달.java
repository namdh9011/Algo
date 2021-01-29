package y2021.m01.d29;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
20
 */


class Main_bj_2839_설탕배달 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp ={0,-1,-1,1,-1,1,2,-1,2,3,2,3,4};
		int a = 0;
		if(N>7) {
			a = dp[((N+2)%5)+8]+(N-8)/5;
		}else {
			a=dp[N];
		}
		System.out.println(a);
	}
}