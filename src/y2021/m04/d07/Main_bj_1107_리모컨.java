package y2021.m04.d07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
메모리 : 11888KB
시간 : 112ms

최적 메모리 : 12944KB
최적 시간 : 68ms
*/
/*
5457
3
6 7 8
 */
public class Main_bj_1107_리모컨 {
	public static int count;
	public static boolean[] remote;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		remote = new boolean[10];
		if(M>0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				int temp = Integer.parseInt(st.nextToken());
				remote[temp]=true;
			}
		}
		int min = Math.abs(N-100);
		for(int i=0;i<=(N+100)*2;i++) {
			if(check(i)) {
				int curr = count+Math.abs(N-i);
				if(curr<min) {
					min=curr;
				}
			}
		}
		System.out.println(min);
	}
	private static boolean check(int num) {
		count=0;
		if(num==0) {
			if(remote[num]) {
				return false;
			}else {
				count=1;
				return true;
			}
		}
		while(num>0) {
			count++;
			if(remote[num%10]) {
				return false;
			}
			num/=10;
		}
		return true;
	}
}


