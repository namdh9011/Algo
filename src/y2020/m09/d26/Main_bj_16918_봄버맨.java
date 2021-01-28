package y2020.m09.d26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*
6 7 5
.......
...O...
....O..
.......
OO.....
OO.....
*/
public class Main_bj_16918_봄버맨 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		boolean[][] bomb = new boolean[R][C];
		int[] di = {-1,0,1,0};
		int[] dj = {0,-1,0,1};
		
		for(int i=0;i<R;i++) {
			String s = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='O') {
					bomb[i][j]=true;
				}
			}
		}
		
		for(int time=1;time<N;time++) {
			boolean f = true;
			if(time%2==0) {
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						if(bomb[i][j]==f) {
							map[i][j]='.';
							for(int d=0;d<di.length;d++) {
								int ni = i+di[d];
								int nj = j+dj[d];
								if(ni>=0&&nj>=0&&ni<R&&nj<C) {
									map[ni][nj]='.';
								}
							}
						}
					}
				}
			}else {
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						if(map[i][j]=='O') {
							bomb[i][j]=true;
						}else {
							bomb[i][j]=false;
						}
						map[i][j]='O';
					}
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
