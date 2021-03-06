package y2021.m03.d07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7
 */


class Main_bj_2606_바이러스 {
	public static boolean visit[];
	public static int answer;
	public static ArrayList<Integer>[] al;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		al = new ArrayList[N+1];
		visit = new boolean[N+1];
		for(int i=0;i<N+1;i++) {
			al[i] = new ArrayList<>();
		}
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			al[a].add(b);
			al[b].add(a);
		}
		answer = -1;
		dfs(1);
		System.out.println(answer);
	}
	private static void dfs(int com) {
		visit[com]=true;
		answer++;
		for(int i=0;i<al[com].size();i++) {
			int curr = al[com].get(i);
			if(!visit[curr]) {
				dfs(curr);
			}
		}
	}
}