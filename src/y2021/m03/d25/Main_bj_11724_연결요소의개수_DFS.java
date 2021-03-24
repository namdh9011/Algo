package y2021.m03.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
6 5
1 2
2 5
5 1
3 4
4 6
 */
public class Main_bj_11724_연결요소의개수_DFS {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for(int i=0;i<N+1;i++) {
			al.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			al.get(u).add(v);
			al.get(v).add(u);
		}
		boolean[] visit = new boolean[al.size()];
		int answer = 0;
		for(int i=1;i<al.size();i++) {
			if(!visit[i]) {
				answer++;
				visit[i]=true;
				visit = dfs(i,visit,al,0);
			}
		}
		System.out.println(answer);
	}

	private static boolean[] dfs(int num, boolean[] visit, ArrayList<ArrayList<Integer>> al, int count) {
		ArrayList<Integer> curr = al.get(num);
		for(int i=0;i<curr.size();i++) {
			if(!visit[curr.get(i)]) {
				visit[curr.get(i)]=true;
				dfs(curr.get(i),visit,al,count);
			}
		}
		return visit;
	}
}
