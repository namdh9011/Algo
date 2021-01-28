package y2020.m10.d28;

import java.util.*;
import java.io.*;
/*
4
10 12 3 9
10 12 7 2
13 11 5 6
10 12 2 12
 */
public class Main_bj_6064_카잉달력 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int result = -1;
			
			int end = N*M/gcd(Integer.max(N, M),Integer.min(N, M));
			for(int i=x;i<=end;i=i+M) {
				int temp=i%N;
				if(temp==0) {
					temp=N;
				}
				if(temp==y) {
					result=i;
					break;
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int gcd(int a, int b) {
		while(b > 0) {
            int tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
	}
}
