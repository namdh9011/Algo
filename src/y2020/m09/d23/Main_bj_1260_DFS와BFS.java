package y2020.m09.d23;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_1260_DFS와BFS {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1260.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int[][] matrix = new int[N+1][N+1];
		boolean[] visit = new boolean[N+1];
		String answer = "";
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int ni = Integer.parseInt(st.nextToken());
			int nj = Integer.parseInt(st.nextToken());
			matrix[ni][nj] = 1;
			matrix[nj][ni] = 1;
		}
		visit[V]=true;
		System.out.println(dfs(N,V,matrix,visit,answer));
		visit = new boolean[N+1];
		visit[V]=true;
		System.out.println(bfs(N,V,matrix,visit,answer));
	}

	private static String bfs(int N, int V, int[][] matrix, boolean[] visit, String answer) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(V);
		answer = V + " ";
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i=1;i<=N;i++) {
				if(matrix[curr][i]==1&&!visit[i]) {
					visit[i]=true;
					answer =answer + i + " ";
					q.add(i);
				}
			}
		}
		return answer;
	}

	private static String dfs(int N, int V, int[][] matrix, boolean[] visit, String answer) {
		answer = V + " ";
		for(int i=1;i<=N;i++) {
			if(matrix[V][i]==1&&!visit[i]) {
				visit[i]=true;
				answer = answer + dfs(N,i,matrix,visit,answer);
			}
		}
		return answer;
	}
}
