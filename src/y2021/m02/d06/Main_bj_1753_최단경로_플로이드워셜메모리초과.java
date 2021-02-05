package y2021.m02.d06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */

class Main_bj_1753_최단경로_플로이드워셜메모리초과 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] fw = new int[V+1][V+1];
		int target = Integer.parseInt(br.readLine());
		for(int i=1;i<=V;i++) {
			for(int j=1;j<=V;j++) {
				if(i!=j) {
					fw[i][j]=123456789;
				}
			}
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			fw[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=Integer.parseInt(st.nextToken());
		}
		for(int k=1;k<=V;k++) {
			for(int i=1;i<=V;i++) {
				for(int j=1;j<=V;j++) {
					fw[i][j]=Math.min(fw[i][j], fw[i][k]+fw[k][j]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<fw.length;i++) {
			if(fw[target][i]==123456789) {
				sb.append("INF").append("\n");
			}else {
				sb.append(fw[target][i]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}