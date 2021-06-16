package y2021.m06.d16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
메모리 : 11996 KB
시간 : 88 ms

최적 메모리 : 13420 KB
최적 시간 : 80 ms
*/
/*
5 8 20
5 8 17
0 0 0
 */
public class Main_bj_4796_캠핑 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(L!=0) {
			int sum = (V/P)*L;
			int diff = V%P;
			if(diff<=L) {
				sum+=diff;
			}else {
				sum+=L;
			}
			sb.append("Case ").append(tc++).append(": ").append(sum).append("\n");
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb.toString());
	}
}


