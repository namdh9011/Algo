package y2021.m09.d09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
메모리 : 11528 KB
시간 : 80 ms

최적 메모리 : 12740 KB
최적 시간 : 68 ms

*/
/*
20
7
23
19
10
15
25
8
13
 */
public class Main_bj_2309_일곱난쟁이 {
	public static int a[];
	public static boolean visit[], flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 9;
		int K = 7;
		int[] height = new int[N];
		visit = new boolean[N];
		a = new int[K];
		for(int i=0;i<N;i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		comb(height, 0, 0 , N, K,0);
		Arrays.sort(a);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<K;i++) {
			sb.append(a[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void comb(int[] height, int count, int start, int N, int K, int sum) {
		if(flag) return;
		if(count==K) {
			if(sum==100) {
				flag=true;
			}
			return;
		}
		for(int i=start;i<N;i++) {
			if(!visit[i]) {
				visit[i]=true;
				a[count] = height[i];
				comb(height, count+1, i, N, K, sum+height[i]);
				if(flag) break;
				visit[i]=false;
			}
		}
	}
}


