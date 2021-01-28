package y2020.m10.d16;

import java.util.*;
import java.io.*;
/*
풀이시간 : 15분
시간 : 320ms
메모리 : 31928KB
- 완탐하면 시간초과
*/
/*
9
5 12 7 10 9 1 2 3 11
13
 */
public class Main_bj_3273_두수의합 {
	public static int input[], count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[N];
		for(int i=0;i<N;i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}
		int X = Integer.parseInt(br.readLine());
		Arrays.sort(input);
		count=0;
		
		int end = N-1;
		for(int i=0;i<N;i++) {
			while(i<end) {
				if(input[i]+input[end]<X) {
					break;
				}
				if(input[i]+input[end]==X) {
					count++;
					break;
				}
				end--;
			}
		}
		System.out.println(count);
	}
}

