package y2021.m02.d27;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
216
 */

class Main_bj_2231_분해합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=1;i<N;i++) {
			int temp = i;
			int M = i;
			while(temp>0) {
				M+=temp%10;
				temp/=10;
			}
			if(M==N) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}