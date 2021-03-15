package y2021.m03.d15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4 7
20 15 10 17
 */

class Main_bj_2805_나무자르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			trees[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(trees);
		System.out.println(solve(trees,N,M));
	}

	private static long solve(int[] trees, int N, int M) {
		long start = 0;
		long end = trees[N-1];
		long mid = (start+end)/2;
		while(start<=end) {
			long sum = 0;
			for(int i=0;i<trees.length;i++) {
				if(trees[i]>mid) {
					sum+=trees[i]-mid;
				}
			}
			if(sum==M) {
				return mid;
			}else if(sum>M){
				start=mid+1;
			}else {
				end=mid-1;
			}
			mid = (start + end)/2;
		}
		return mid;
	}
}