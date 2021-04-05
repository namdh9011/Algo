package y2021.m04.d05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
메모리 : 11456KB
시간 : 76ms

최적 메모리 : 12832KB
최적 시간 : 68ms
*/
/*
1 16 16
 */
public class Main_bj_1476_날짜계산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int year=1,e=1,s=1,m=1;
		while(true) {
			if(E==e&&S==s&&M==m) {
				break;
			}
			if(++e>15) e=1;
			if(++s>28) s=1;
			if(++m>19) m=1;
			year++;
		}
		System.out.println(year);
	}
}


