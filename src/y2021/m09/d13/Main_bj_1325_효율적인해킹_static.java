package y2021.m09.d13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
public class Main_bj_1325_효율적인해킹_static {
	public static ArrayList<ArrayList<Integer>> graph;
	public static boolean visit[];
	public static int count;
	public static void main(String[] args) throws Exception {
		//init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
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
			visit = new boolean[N+1];
			visit[i]=true;
			count=1;
			dfs(i);
			viruscount[i]=count;
			if(count>max) {
				max = count;
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

	private static void dfs(int comnum) {
		ArrayList<Integer> curr = graph.get(comnum);
		int len = curr.size();
		for(int i=0;i<len;i++) {
			int nextcom = curr.get(i);
			if(!visit[nextcom]) {
				visit[nextcom]=true;
				count++;
				dfs(nextcom);
			}
		}
	}
}


