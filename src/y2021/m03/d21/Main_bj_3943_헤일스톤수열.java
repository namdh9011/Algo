package y2021.m03.d21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
4
1
3
9999
100000
 */
public class Main_bj_3943_헤일스톤수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
			while(true) {
				if(n>answer) {
					answer = n;
				}
				if(n==1) {
					break;
				}
				if(n%2==0) {
					n/=2;
				}else {
					n=n*3+1;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
