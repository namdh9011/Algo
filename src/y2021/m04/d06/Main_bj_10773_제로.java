package y2021.m04.d06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
메모리 : 20092KB
시간 : 192ms

최적 메모리 : 13532KB
최적 시간 : 92ms
*/
/*
10
1
3
5
4
0
0
7
0
0
6
 */
public class Main_bj_10773_제로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int[] stack = new int[100001];
		int top=0;
		for(int i=0;i<K;i++) {
			int curr = Integer.parseInt(br.readLine());
			if(curr==0) {
				top--;
				if(top<0) top=0;
			}else {
				stack[top]=curr;
				top++;
			}
		}
		int sum =0;
		for(int i=0;i<top;i++) {
			sum+=stack[i];
		}
		System.out.println(sum);
	}
}


