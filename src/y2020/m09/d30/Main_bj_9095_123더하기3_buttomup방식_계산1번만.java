package y2020.m09.d30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
풀이시간 : 10분
시간 : 108ms
메모리 : 20984KB
- topdown방식
- 점화식 연습 수준
- 테케 안에 가장큰수로 한번만 dp해주면됨 *********
*/
/*
3
4
7
10
 */
public class Main_bj_9095_123더하기3_buttomup방식_계산1번만 {
	
	public static long memo[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int num[] = new int[T];
		int max = 0;
		for(int tc=0;tc<T;tc++) {
			num[tc] = Integer.parseInt(br.readLine());
			if(max<num[tc]) {
				max=num[tc];
			}
		}
		memo = new long[max+3];
		memo[1]=1;
		memo[2]=2;
		memo[3]=4;
		if(max>3) {
			for(int i=4;i<=max;i++) {
				memo[i]=memo[i-1]%1000000009+memo[i-2]%1000000009+memo[i-3]%1000000009;
			}
		}
		
		for(int i=0;i<T;i++) {
			sb.append(memo[num[i]]%1000000009).append("\n");
		}
		System.out.println(sb.toString());
	}
}
