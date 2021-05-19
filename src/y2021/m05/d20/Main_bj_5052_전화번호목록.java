package y2021.m05.d20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
/*
메모리 : 97248KB
시간 : 604ms

최적 메모리 : 102264KB
최적 시간 : 232ms
*/
/*
2
3
911
97625999
91125426
5
113
12340
123440
12345
98346
 .
.
 */
public class Main_bj_5052_전화번호목록 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		here:for(int tc=0;tc<T;tc++) {
			HashSet<String> set = new HashSet<>();
			int N = Integer.parseInt(br.readLine());
			String[] data = new String[N];
			for(int i=0;i<N;i++) {
				String d = br.readLine();
				data[i]=d;
				set.add(d);
			}
			for(int i=0;i<N;i++) {
				String curr = data[i];
				int cn = curr.length();
				for(int j=1;j<cn;j++) {
					String temp = curr.substring(0,j);
					if(set.contains(temp)) {
						sb.append("NO\n");
						continue here;
					}
				}
			}
			sb.append("YES\n");
		}
		System.out.println(sb.toString());
	}
}


