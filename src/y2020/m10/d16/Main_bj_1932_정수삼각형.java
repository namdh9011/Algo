package y2020.m10.d16;

import java.util.*;
import java.io.*;
/*
풀이시간 : 15분
시간 : 244ms
메모리 : 26096KB
- 
*/
/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
 */
public class Main_bj_1932_정수삼각형 {
	public static int input[][],dp[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		input = new int[N][N];
		dp = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<i+1;j++) {
				input[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=input[0][0];
		for(int i=1;i<N;i++) {
			for(int j=0;j<i+1;j++) {
				int a = 0;
				int b = 0;
				a = dp[i-1][j]+input[i][j];
				if(j-1>=0) {
					b = dp[i-1][j-1]+input[i][j];
				}
				dp[i][j]=Integer.max(a, b);
			}
		}
		Arrays.sort(dp[N-1]);
		System.out.println(dp[N-1][N-1]);
	}
}