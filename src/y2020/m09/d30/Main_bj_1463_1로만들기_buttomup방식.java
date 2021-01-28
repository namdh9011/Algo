package y2020.m09.d30;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
풀이시간 : 25분
시간 : 104ms
메모리 : 16988KB
- buttom - up 방식
*/
/*
- BUTTOM - UP 방식
 */
public class Main_bj_1463_1로만들기_buttomup방식 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] number = new int[N+1];
		if(N==1) {
			number[1]=0;
		}else if(N==2) {
			number[2]=1;
		}else if(N==3) {
			number[3]=1;
		}else if(N>3) {
			number[1]=0;
			number[2]=1;
			number[3]=1;
			for(int i=4;i<=N;i++) {
				int a = Integer.MAX_VALUE;
				int b = Integer.MAX_VALUE;
				int c = Integer.MAX_VALUE;
				if(i%3==0) {
					a=1+number[i/3];
				}
				if(i%2==0) {
					b=1+number[i/2];
				}
				c=1+number[i-1];
				number[i]=Math.min(a, Math.min(b, c));
			}
		}
		System.out.println(number[N]);
	}
}
