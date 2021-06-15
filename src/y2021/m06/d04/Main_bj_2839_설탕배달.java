package y2021.m06.d04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
메모리 : 11476 KB
시간 : 76 ms

최적 메모리 : 12848 KB
최적 시간 : 68 ms
*/
/*
18
 */
public class Main_bj_2839_설탕배달 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		while(N%5!=0) {
			N-=3;
			if(N<0) break;
			count++;
		}
		if(N<0) {
			System.out.println(-1);
		}else {
			System.out.println(count+N/5);
		}
	}
}


