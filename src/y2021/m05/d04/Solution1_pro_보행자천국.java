package y2021.m05.d04;

import java.util.*;
//답 보고 풀었음.
//다시 풀어 볼 것.


public class Solution1_pro_보행자천국 {
	public static void main(String[] args) {
		int m = 3;
		int n = 6;
		int[][] picture = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
		System.out.println(solution(m, n, picture));
	}
	static int MOD = 20170805;
	public static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][][] dp = new int[m+1][n+1][2];
        // dp[][][0] 아래쪽, dp[][][1] 오른쪽
        dp[1][1][0]=1;
        dp[1][1][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(cityMap[i-1][j-1]==0){
                    dp[i][j][0]+=(dp[i-1][j][0]+dp[i][j-1][1])%MOD;
                    dp[i][j][1]+=(dp[i-1][j][0]+dp[i][j-1][1])%MOD;
                }else if(cityMap[i-1][j-1]==1){
                    dp[i][j][0]=0;
                    dp[i][j][1]=0;
                }else {
                    dp[i][j][0]=dp[i-1][j][0];
                    dp[i][j][1]=dp[i][j-1][1];
                }
            }
        }
        answer = dp[m][n][0];
        return answer;
    }
}
