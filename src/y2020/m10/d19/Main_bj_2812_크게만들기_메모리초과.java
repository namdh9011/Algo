package y2020.m10.d19;

import java.util.*;
import java.io.*;
/*
풀이시간 : 
시간 : 
메모리 : 
- 
*/
/*
3 2
192
 */
public class Main_bj_2812_크게만들기_메모리초과 {
	public static String head;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String input = br.readLine();
		head ="";
		String s = dfs(input,N,K);
		System.out.println(head + s);
	}
	public static String dfs(String input, int n, int k) {
		if(k==0) {
			return input;
		}
		if(k+1<n) {
			int index = 0;
			int max = Integer.MIN_VALUE;
			for(int i=0;i<k+1;i++) {
				int curr = input.charAt(i);
				if(curr=='9') {
					max='9'; 
					index = i;
					break;
				}
				if(curr>max) {
					max=curr;
					index = i;
				}
			}
			if(index==0) {
				head = head + input.substring(0,1);
				input = dfs(input.substring(1,n),n-1,k);
			}else {
				input = dfs(input.substring(index,n),n-index,k-index);
			}
			return input;
		}else {
			while(k>0) {
				int index = 0;
				int min = Integer.MAX_VALUE;
				for(int i=0;i<n;i++) {
					int curr = input.charAt(i);
					if(min>curr) {
						min = curr;
						index = i;
					}
				}
				input = input.substring(0,index)+input.substring(index+1,n);
				n--;
				k--;
			}
			return input;
		}
	}
}

