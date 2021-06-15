package y2021.m06.d04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
메모리 : 11504 KB
시간 : 80 ms

최적 메모리 : 11536 KB
최적 시간 : 68 ms
*/
/*
10 4200
1
5
10
50
100
500
1000
5000
10000
50000
 */
public class Main_bj_11047_동전0 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		int count = 0;
		for(int i=N-1;i>=0;i--) {
			int curr = arr[i];
			count+=K/curr;
			K%=curr;
		}
		System.out.println(count);
	}
}


