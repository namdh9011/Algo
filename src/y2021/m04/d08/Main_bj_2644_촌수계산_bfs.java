package y2021.m04.d08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
메모리 : 11888KB
시간 : 112ms

최적 메모리 : 12944KB
최적 시간 : 68ms
*/
/*
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6
 */
public class Main_bj_2644_촌수계산_bfs {
	public static ArrayList<ArrayList<Integer>> al;
	public static boolean visit[];
	public static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tar1 = Integer.parseInt(st.nextToken());
		int tar2 = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		al = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			al.add(new ArrayList<Integer>());
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			al.get(x).add(y);
			al.get(y).add(x);
		}
		answer = -1;
		bfs(tar1, tar2);
		System.out.println(answer);
	}
	private static void bfs(int tar1, int tar2) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {tar1, 0});
		visit[tar1]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			ArrayList<Integer> start = al.get(curr[0]);;
			for(int i=0;i<start.size();i++) {
				int next = start.get(i);
				if(!visit[next]) {
					visit[next]=true;
					if(next==tar2) {
						answer = curr[1]+1;
						return;
					}
					q.add(new int[] {next, curr[1]+1});
				}
			}
		}
	}
}