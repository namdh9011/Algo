package y2021.m03.d24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
5 4
1 2 3
3 4 4
1 4 1
2 2 2
 */
public class Main_bj_10810_공넣기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] basket = new int[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for(int j=a;j<=b;j++) {
				basket[j]=c;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			sb.append(basket[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
