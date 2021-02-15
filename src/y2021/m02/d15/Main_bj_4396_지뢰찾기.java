package y2021.m02.d15;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
8
...**..*
......*.
....*...
........
........
.....*..
...**.*.
.....*..
xxx.....
xxxx....
xxxx....
xxxxx...
xxxxx...
xxxxx...
xxx.....
xxxxx...
 */

class Main_bj_4396_지뢰찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] bomb = new int[N][N];
		int[][] play = new int[N][N];
		boolean flag = false;
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<N;j++) {
				bomb[i][j]=input.charAt(j);
			}
		}
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<N;j++) {
				play[i][j]=input.charAt(j);
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(play[i][j]=='x') {
					if(bomb[i][j]=='*') {
						flag = true;
					}else {
						bomb[i][j]=0;
						for(int k=-1;k<=1;k++) {
							for(int l=-1;l<=1;l++) {
								int ni = i+k;
								int nj = j+l;
								if(ni>=0&&nj>=0&&ni<N&&nj<N&&bomb[ni][nj]=='*') {
									bomb[i][j]++;
								}
							}
						}
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(bomb[i][j]=='.') {
					sb.append('.');
				}else if(bomb[i][j]=='*') {
					if(flag) {
						sb.append('*');
					}else {
						sb.append('.');
					}
				}else {
					sb.append(bomb[i][j]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}