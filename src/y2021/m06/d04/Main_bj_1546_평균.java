package y2021.m06.d04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
메모리 : 11748 KB
시간 : 84 ms

최적 메모리 : 13080 KB
최적 시간 : 72 ms
*/
/*
3
40 80 60
 */
public class Main_bj_1546_평균 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		int max = 0;
		int temp =0;
		for(int i=0;i<N;i++) {
			temp = Integer.parseInt(st.nextToken());
			sum+=temp;
			if(max<temp) max=temp;
		}
		System.out.println((double)sum/max*100/N);
	}
}


