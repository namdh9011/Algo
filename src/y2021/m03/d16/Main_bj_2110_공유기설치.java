package y2021.m03.d16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4 7
20 15 10 17
 */

class Main_bj_2110_공유기설치 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] homes = new int[N];
		for(int i=0;i<N;i++) {
			homes[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(homes);
		System.out.println(solve(homes,N,C));
	}
	public static int solve(int[] homes, int N, int C) {
		int start=1;
		int end=homes[N-1];
		int mid = (start + end)/2;
		while(start<=end) {
			int curr = homes[0];
			int count = 1;
			for(int i=1;i<N;i++) {
				if(homes[i]-curr>=mid) {
					curr=homes[i];
					count++;
				}
			}
			if(count>=C) {
				start=mid+1;
			}else {
				end=mid-1;
			}
			mid = (start + end)/2;
		}
		return mid;
	}
}