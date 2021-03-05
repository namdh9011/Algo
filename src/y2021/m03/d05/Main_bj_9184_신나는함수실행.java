package y2021.m03.d05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1 1 1
2 2 2
10 4 6
50 50 50
-1 7 18
-1 -1 -1
 */


class Main_bj_9184_신나는함수실행 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a = 0;
		int b = 0;
		int c = 0;
		StringBuilder sb = new StringBuilder();
		while(a!=-1&&b!=-1&&c!=-1) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			System.out.println(w(a,b,c));
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a,b,c)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int w(int a, int b, int c) {
		if(a<=0||b<=0||c<=0) {
			return 1;
		}
		if(a>20||b>20||c>20) {
			return w(20,20,20);
		}
		if(a<b&&b<c) {
			return w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
		}else {
			return w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
		}
	}
}