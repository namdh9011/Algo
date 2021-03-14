package y2021.m03.d13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
4 1 5 2 3
5
1 3 7 9 5
 */

class Main_bj_1920_수찾기_이분탐색 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			int curr = Integer.parseInt(st.nextToken());
			sb.append(solve(arr,curr,0,N-1)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int solve(int[] arr, int curr, int start, int end) {
		while(start<=end) {
			int mid=(start+end)/2;
			if(curr==arr[mid]) {
				return 1;
			}else if(curr>arr[mid]) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return 0;
	}
}