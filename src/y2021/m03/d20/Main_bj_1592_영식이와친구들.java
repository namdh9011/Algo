package y2021.m03.d20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
5 3 2
 */
public class Main_bj_1592_영식이와친구들 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] seat = new int[N];
		seat[0]=1;
		int index=0;
		int step=0;
		while(true) {
			step++;
			if(seat[index]%2==1) {
				index=(index+L)%N;
			}else {
				index=(index-L)%N;
				if(index<0) {
					index+=N;
				}
			}
			seat[index]++;
			if(seat[index]==M) {
				break;
			}
		}
		System.out.println(step);
	}
}
