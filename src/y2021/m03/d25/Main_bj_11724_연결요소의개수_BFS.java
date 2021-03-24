package y2021.m03.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
6 5
1 2
2 5
5 1
3 4
4 6
 */
public class Main_bj_11724_연결요소의개수_BFS {
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
		System.out.println(bfs(al));
	}

	private static int bfs(ArrayList<ArrayList<Integer>> al) {
		boolean[] visit = new boolean[al.size()];
		int answer = 0;
		for(int i=1;i<al.size();i++) {
			if(!visit[i]) {
				answer++;
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				while(!q.isEmpty()) {
					ArrayList<Integer> curral = al.get(q.poll());
					for(int j=0;j<curral.size();j++) {
						if(!visit[curral.get(j)]) {
							visit[curral.get(j)]=true;
							q.add(curral.get(j));
						}
					}
				}
			}
		}
		return answer;
	}
}
