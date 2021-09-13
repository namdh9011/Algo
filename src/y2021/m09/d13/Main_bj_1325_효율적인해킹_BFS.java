package y2021.m09.d13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
메모리 : 11528 KB
시간 : 80 ms

최적 메모리 : 12740 KB
최적 시간 : 68 ms

*/
/*
5 4
3 1
3 2
4 3
5 3
 */
public class Main_bj_1325_효율적인해킹_BFS {
	public static void main(String[] args) throws Exception {
		//init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0;i<N+1;i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int child = Integer.parseInt(st.nextToken());
			int parents = Integer.parseInt(st.nextToken());
			graph.get(parents).add(child);
		}
	
		//solve
		int[] viruscount = new int[N+1];
		int max = 0;
		for(int i=1;i<=N;i++) {
			int res = bfs(graph, i, 1, N);
			viruscount[i]=res;
			if(res>max) {
				max = res;
			}
		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			if(viruscount[i]==max) {
				answer.add(i);
			}
		}
		
		//print
		StringBuilder sb = new StringBuilder();
		int len = answer.size();
		for(int i=0;i<len;i++) {
			sb.append(answer.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static int bfs(ArrayList<ArrayList<Integer>> graph, int comnum, int viruscount, int N) {
		boolean[] visit = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(comnum);
		visit[comnum]=true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			ArrayList<Integer> next = graph.get(curr);
			int len = next.size();
			for(int i=0;i<len;i++) {
				int vicom = next.get(i);
				if(!visit[vicom]) {
					q.add(vicom);
					viruscount++;
				}
			}
		}
		return viruscount;
	}
}


