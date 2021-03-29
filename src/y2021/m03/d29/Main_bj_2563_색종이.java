package y2021.m03.d29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
메모리 : 11588KB
시간 : 76ms

최적 메모리 : 11420KB
최적 시간 : 68ms
*/
/*
3
3 7
15 7
5 2
 */
public class Main_bj_2563_색종이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boolean[][] paper = new boolean[100][100];
		int answer = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int j=a;j<a+10;j++) {
				for(int k=b;k<b+10;k++) {
					if(!paper[j][k]) {
						paper[j][k]=true;
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
