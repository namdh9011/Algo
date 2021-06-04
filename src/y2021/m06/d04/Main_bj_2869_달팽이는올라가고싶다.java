package y2021.m06.d04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
메모리 : 11504 KB
시간 : 76 ms

최적 메모리 : 12784 KB
최적 시간 : 68 ms
*/
/*
2 1 5
 */
public class Main_bj_2869_달팽이는올라가고싶다 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int day = 1;
		if((V-A)%(A-B)==0){
			day+=(V-A)/(A-B);
		}else {
			if(V-A!=0) {
				day+=(V-A)/(A-B)+1;
			}
		}
		System.out.println(day);
	}
}


