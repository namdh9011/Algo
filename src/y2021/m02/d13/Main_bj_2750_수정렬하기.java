package y2021.m02.d13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
5
5
2
3
4
1
 */

class Main_bj_2750_수정렬하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}