package y2020.m10.d09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
풀이시간 : 25분
시간 : 92ms
메모리 : 13328KB
-
*/
/*
3 5 6 1
1 2 3
 */
public class Main_bj_16938_캠프준비 {
	public static int N,L,R,X,a[],co[],answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		answer = 0;
		a = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		for(int i=1;i<=N;i++) {
			co = new int[i];
			comb(0,i,0,0);
		}
		System.out.println(answer);
	}
	private static void comb(int cnt, int k,int sum,int start) {
		if(sum>R) {
			return;
		}
		if(cnt==k) {
			if(sum>=L&&sum<=R) {
				if(co[co.length-1]-co[0]>=X) {
					answer++;
				}
			}
			return;
		}
		for(int i=start;i<N;i++) {
			co[cnt]=a[i];
			comb(cnt+1,k,sum+a[i],i+1);
		}
	}
}
