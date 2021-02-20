package y2021.m02.d20;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
baekjoon
 */

class Main_bj_10809_알파벳찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] result = new int[26];
		for(int i=0;i<result.length;i++) {
			result[i]=-1;
		}
		for(int i=0;i<input.length();i++) {
			int index = input.charAt(i)-'a';
			if(result[index]==-1) {
				result[index]=i;
			}
		}
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i] + " ");
		}
	}
}