package y2021.m06.d03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
메모리 : 11468 KB
시간 : 80 ms

최적 메모리 : 12752 KB
최적 시간 : 64 ms
*/
/*
150
266
427
 */
public class Main_bj_2577_숫자의개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int muilt = A*B*C;
		int[] count = new int[10];
		while(muilt>0) {
			count[muilt%10]++;
			muilt/=10;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<10;i++) {
			sb.append(count[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}


