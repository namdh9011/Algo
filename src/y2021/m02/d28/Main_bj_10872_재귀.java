package y2021.m02.d28;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
216
 */

class Main_bj_10872_재귀 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(factorial(N));
	}

	private static int factorial(int N) {
		if(N<=1) {
			return 1;
		}
		return N*factorial(N-1);
	}
}