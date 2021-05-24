package y2021.m05.d24;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
메모리 : 11476KB
시간 : 76ms

최적 메모리 : 12812KB
최적 시간 : 68ms
*/
/*
3 7
 */
public class Main_bj_1292_쉽게푸는문제 {
	public static int A,B;
	public static void main(String[] args) throws Exception {
		init();
		System.out.println(solve());
		
	}
	private static int solve() {
		int[] sum = new int[B+1];
		int index = 1;
		for(int i=1;i<=B;i++) {
			for(int j=1;j<=i;j++) {
				if(index>B) {
					return sum[B]-sum[A-1];
				}
				sum[index]=sum[index-1]+i;
				index++;
			}
		}
		return 1;
	}

	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
	}
}


