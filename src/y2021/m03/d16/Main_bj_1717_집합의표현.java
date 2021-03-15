package y2021.m03.d16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */

class Main_bj_1717_집합의표현 {
	public static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		for(int i=0;i<=N;i++) {
			arr[i]=i;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(com==0) {
				union(a,b);
			}else {
				a = find(a);
				b = find(b);
				String s = (a==b)?"YES":"NO";
				sb.append(s).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			arr[b]=a;
		}
	}
	public static int find(int x) {
		if(x==arr[x]) {
			return x;
		}else {
			return arr[x]=find(arr[x]);
		}
	}
}