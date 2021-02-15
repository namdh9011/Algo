package y2021.m02.d15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3 2
..
.*
..
5 5
*.*.*
..*..
*****
.....
..**.
0 0
 */

class Main_bj_4108_지뢰찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(R==0) {
				break;
			}
			int[][] result = new int[R][C];
			for(int i=0;i<R;i++) {
				String input = br.readLine();
				for(int j=0;j<C;j++) {
					if(input.charAt(j)=='*') {
						for(int k=-1;k<=1;k++) {
							for(int l=-1;l<=1;l++) {
								if(k==0&&l==0) {
									continue;
								}
								int ni = i+k;
								int nj = j+l;
								if(ni>=0&&nj>=0&&ni<R&&nj<C) {
									result[ni][nj]++;
								}
							}
						}
						result[i][j]=-9;
					}
				}
			}
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(result[i][j]<0) {
						sb.append("*");
					}else {
						sb.append(result[i][j]);
					}
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}