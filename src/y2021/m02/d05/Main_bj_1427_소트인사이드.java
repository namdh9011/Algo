package y2021.m02.d05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
2143
 */

class Main_bj_1427_소트인사이드 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] temp = s.split("");
		Arrays.sort(temp);
		StringBuilder sb = new StringBuilder();
		for(int i=temp.length-1;i>=0;i--) {
			sb.append(temp[i]);
		}
		System.out.println(sb.toString());
	}
}