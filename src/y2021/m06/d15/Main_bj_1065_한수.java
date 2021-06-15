package y2021.m06.d15;

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
public class Main_bj_1065_한수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=1;i<=N;i++) {
			if(checkHan(i)) answer++; 
		}
		System.out.println(answer);
	}

	private static boolean checkHan(int num) {
		if(num<10) return true;
		int diff = num%10-(num/10)%10;
		while(num>9) {
			int curr = num%10-(num/10)%10;
			if(diff!=curr) return false;
			num/=10;
		}
		return true;
	}
}


