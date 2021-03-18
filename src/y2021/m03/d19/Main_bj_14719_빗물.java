package y2021.m03.d19;

import java.util.*;
import java.io.*;
/*
4 4
3 0 1 4
 */
public class Main_bj_14719_빗물 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] blocks = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<W;i++) {
			blocks[i]=Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int lmax = 0;
		for(int i=0;i<W;i++) {
			int rmax = 0;
			for(int j=i+1;j<W;j++) {
				if(blocks[j]>rmax) {
					rmax = blocks[j];
				}
			}
			int min = Math.min(lmax,rmax);
			if(min-blocks[i]>0) {
				sum+=min-blocks[i];
			}
			if(blocks[i]>lmax) {
				lmax = blocks[i];
			}
		}
		System.out.println(sum);
	}
}
