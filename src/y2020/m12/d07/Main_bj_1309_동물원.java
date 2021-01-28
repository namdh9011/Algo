package y2020.m12.d07;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
4
 */

class Main_bj_1309_동물원 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] dp = new int[N+1];
    	dp[0] = 3;
		dp[1] = 7;
    	if(N>2){
    		dp[1] = 7;
    		for(int i=2;i<N;i++) {
    			dp[i]=(dp[i-1]*2 + dp[i-2])%9901;
    		}
    	}
    	System.out.println(dp[N-1]);
	}
}