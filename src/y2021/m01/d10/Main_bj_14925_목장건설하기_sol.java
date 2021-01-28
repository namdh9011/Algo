package y2021.m01.d10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
6 6
0 0 0 1 0 0
0 0 0 2 1 0
0 0 2 0 0 0
0 1 0 0 0 0
2 0 0 0 0 0
0 0 0 0 0 0
*/

class Main_bj_14925_목장건설하기_sol {
	static int M,N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int map[][] = new int[M+1][N+1];
		int res = 0;
		for(int i = 1 ; i <= M ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= N ; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 0) {
					map[i][j] = Math.min(map[i-1][j-1], Math.min(map[i-1][j], map[i][j-1])) + 1;
					res = Math.max(res, map[i][j]);
				}
			}
		}
		System.out.println(res);
		for(int i=0;i<M+1;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
