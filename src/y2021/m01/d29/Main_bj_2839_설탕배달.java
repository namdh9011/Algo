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
		int[] dp ={0,-1,-1,1,-1,1,2,-1,2,3,2,3,4,3,4,3};
		int a = 0;
		if(N>15) {
			a = dp[(N%5)+10]+(N-10)/5;
		}else {
			a=dp[N];
		}
		System.out.println(a);
	}
}