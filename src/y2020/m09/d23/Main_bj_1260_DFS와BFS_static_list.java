package y2020.m09.d23;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_bj_1260_DFS와BFS_static_list {
	public static int N,M,V;
	public static ArrayList<Integer>[] al;
	public static boolean visit[];
	public static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bj_1260.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		al = new ArrayList[N+1];
		visit = new boolean[N+1];
		sb = new StringBuilder();
		
		for(int i=1;i<=N;i++) {
			al[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int ni = Integer.parseInt(st.nextToken());
			int nj = Integer.parseInt(st.nextToken());
			al[ni].add(nj);
			al[nj].add(ni);
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(al[i]);
		}
		
		visit[V]=true;
		dfs(V);
		sb.append("\n");
		visit[V]=false;
		bfs(V);
		System.out.println(sb);
	}

	private static void bfs(int V) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(V);
		sb.append(V).append(" ");
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i=0;i<al[curr].size();i++) {
				int temp = al[curr].get(i);
				if(visit[temp]) {
					visit[temp]=false;
					sb.append(temp).append(" ");
					q.add(temp);
				}
			}
		}
	}

	private static void dfs(int V) {
		sb.append(V).append(" ");
		for(int i=0;i<al[V].size();i++) {
			int temp = al[V].get(i);
			if(!visit[temp]) {
				visit[temp]=true;
				dfs(temp);
			}
		}
	}
}
