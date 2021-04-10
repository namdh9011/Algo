package y2021.m04.d11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
메모리 : 23744KB
시간 : 696ms

최적 메모리 : 19820KB
최적 시간 : 216ms
*/
/*
5
1 1 1 6 0
2 7 8 3 1
 */
public class Main_bj_1026_보물 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		Integer[] B = new Integer[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st1.nextToken());
			B[i]=Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(A);
		Arrays.sort(B);
		int sum = 0;
		for(int i=0;i<N;i++) {
			sum+=A[i]*B[N-i-1];
		}
		System.out.println(sum);
	}
}