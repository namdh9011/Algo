package y2021.m02.d15;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
5
1....
..3..
.....
.4...
...9.
 */

class Main_bj_1996_지뢰찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<N;j++) {
				if(input.charAt(j)!='.') {
					int count = input.charAt(j)-'0';
					for(int k=-1;k<=1;k++) {
						for(int l=-1;l<=1;l++) {
							int ni = i+k;
							int nj = j+l;
							if(ni>=0&&nj>=0&&ni<N&&nj<N) {
								map[ni][nj]+=count;
							}
						}
					}
					map[i][j]=Integer.MIN_VALUE;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]<0) {
					sb.append('*');
				}else if(map[i][j]>=10) {
					sb.append('M');
				}else {
					sb.append(map[i][j]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}