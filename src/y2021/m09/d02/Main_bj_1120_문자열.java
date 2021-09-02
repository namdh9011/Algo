package y2021.m09.d02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
메모리 : 11480 KB
시간 : 76 ms

최적 메모리 : 12876 KB
최적 시간 : 68 ms
*/
/*
adaabc aababbc
 */
public class Main_bj_1120_문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		int lena = A.length();
		int lenb = B.length();
		int min = Integer.MAX_VALUE;
		for(int i=0;i<=lenb-lena;i++) {
			int count = 0;
			for(int j=0;j<lena;j++) {
				if(A.charAt(j)!=B.charAt(j+i)) {
					count++;
				}
				if(count>min) {
					break;
				}
			}
			if(min>count) {
				min = count;
			}
		}
		System.out.println(min);
	}
}


