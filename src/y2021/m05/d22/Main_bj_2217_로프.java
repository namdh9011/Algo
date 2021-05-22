package y2021.m05.d22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
메모리 : 22520KB
시간 : 260ms

최적 메모리 : 15944KB
최적 시간 : 148ms
*/
/*
2
10
15
 */
public class Main_bj_2217_로프 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ropes = new int[N];
		for(int i=0;i<N;i++) {
			ropes[i]=Integer.parseInt(br.readLine());
		}
		int answer = 0;
		Arrays.sort(ropes);
		for(int i=0;i<N;i++) {
			answer=Math.max(answer, ropes[i]*(N-i));
		}
		System.out.println(answer);
	}
}


