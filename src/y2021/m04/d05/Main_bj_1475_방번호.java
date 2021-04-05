package y2021.m04.d05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
메모리 : 11440KB
시간 : 76ms

최적 메모리 : 12788KB
최적 시간 : 68ms
*/
/*
9999
 */
public class Main_bj_1475_방번호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] visit = new int[10];
		for(int i=0;i<s.length();i++) {
			int num = s.charAt(i)-'0';
			visit[num]++;
		}
		visit[6]+=visit[9];
		visit[6] = (visit[6]%2==0) ? visit[6]/2 : visit[6]/2+1;
		int max = 0;
		for(int i=0;i<9;i++) {
			if(visit[i]>max) {
				max=visit[i];
			}
		}
		System.out.println(max);
	}
}


