package y2021.m03.d02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
 */


class Main_bj_1018_체스판다시칠하기 {
	public static char board[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j]=temp.charAt(j);
			}
		}
		int answer = 64;
		for(int i=0;i<N-7;i++) {
			for(int j=0;j<M-7;j++) {
				int min = checkBoard(i,j);
				if(min<answer) {
					answer = min;
				}
			}
		}
		System.out.println(answer);
	}

	private static int checkBoard(int x, int y) {
		int[] t = {'W','B'};
		int c1=0;
		int c2=0;
		for(int i=x;i<x+8;i++) {
			for(int j=y;j<y+8;j++) {
				if(board[i][j]!=t[(i+j)%2]) {
					c1++;
				}
				if(board[i][j]!=t[(i+j+1)%2]) {
					c2++;
				}
			}
		}
		return Math.min(c1, c2);
	}
}