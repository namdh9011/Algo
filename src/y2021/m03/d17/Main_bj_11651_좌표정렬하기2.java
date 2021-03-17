package y2021.m03.d17;

import java.util.*;
import java.io.*;
/*
5
0 4
1 2
1 -1
2 2
3 3
 */
public class Main_bj_11651_좌표정렬하기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] xy = new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			xy[i][0] = Integer.parseInt(st.nextToken());
			xy[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(xy,new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1]>o2[1]) {
					return 1;
				}else if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				return -1;
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(xy[i][0] + " " + xy[i][1]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
