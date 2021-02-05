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
/*
20000 1
1
10000 10000 3
 */
class Main_bj_1753_최단경로_다익스트라_다시풀기 {
	public static int INF = 123456789;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[][] matrix = new int[V+1][V+1];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			matrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		int[] dest = new int[V+1];
		boolean[] visit = new boolean[V+1];
		for(int i=1;i<=V;i++) {
			dest[i]=INF;
		}
		dest[K]=0;
		visit[K]=true;
		
		for(int i=1;i<V+1;i++) {
			if(!visit[i]&&matrix[K][i]!=0) {
				dest[i]=matrix[K][i];
			}
		}
		
		for(int i=0;i<V-1;i++) {
			int min = INF;
			int minindex=-1;
			for(int j=0;j<dest.length;j++) {
				if(!visit[j]&&dest[j]<min&&dest[j]!=INF) {
					min=dest[j];
					minindex=j;
				}
			}
			
			visit[minindex]=true;
			for(int j=1;j<V+1;j++) {
				if(!visit[j]&&matrix[minindex][j]!=0) {
					dest[j]=Math.min(dest[j], dest[minindex]+matrix[minindex][j]);
				}
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<dest.length;i++) {
			if(dest[i]==INF) {
				sb.append("INF").append("\n");
			}else {
				sb.append(dest[i]).append("\n");
				
			}
		}
		System.out.println(sb.toString());
	}
}