package y2021.m01.d31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
0 32
3 13
28 25
17 5
21 20
11 0
12 12
4 2
0 8
21 0
 */


class Main_bj_2460_지능형기차2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		int max = 0;
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			sum = sum-Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
			if(sum>max) {
				max = sum;
			}
		}
		System.out.println(max);
	}
}