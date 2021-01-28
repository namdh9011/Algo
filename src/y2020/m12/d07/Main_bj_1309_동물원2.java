package y2020.m12.d07;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
4
 */

class Main_bj_1309_동물원2 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[][] dp = new int[N][3];
    	if(N==1) {
    		System.out.println(3);
    	}else {
    		dp[0][0]=3;
    		dp[0][1]=2;
    		dp[0][2]=2;
    		for(int i=1;i<N;i++) {
    			dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901;
    			dp[i][1]=(dp[i-1][0]+dp[i-1][2])%9901;
    			dp[i][2]=(dp[i-1][0]+dp[i-1][1])%9901;
    		}
    		System.out.println(dp[N-1][0]);
    	}
	}
}