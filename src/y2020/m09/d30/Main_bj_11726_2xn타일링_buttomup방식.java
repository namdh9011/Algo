package y2020.m09.d30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
풀이시간 : 15분
시간 : 84ms
메모리 : 12980KB
- buttom-up 방식
*/
/*
9
 */
public class Main_bj_11726_2xn타일링_buttomup방식 {
	public static int memo[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int[N+2];
		memo[1]=1;
		memo[2]=2;
		if(N>2) {
			for(int i=3;i<=N;i++) {
				memo[i]=memo[i-1]%10007+memo[i-2]%10007;
			}
		}
		System.out.println(memo[N]%10007);
	}
}
