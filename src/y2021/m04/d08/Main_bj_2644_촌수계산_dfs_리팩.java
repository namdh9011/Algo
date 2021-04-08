package y2021.m04.d08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
메모리 : 11576KB
시간 : 88ms

최적 메모리 : 12952KB
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
public class Main_bj_2644_촌수계산_dfs_리팩 {
	public static ArrayList<ArrayList<Integer>> al;
	public static boolean visit[];
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
		visit[tar1]=true;
		System.out.println(dfs(-1, 0, tar1, tar2));
	}
	private static int dfs(int answer, int cnt, int tar1, int tar2) {
		if(tar1==tar2) {
			answer=cnt;
			return answer;
		}
		if(visit[tar2]) return answer;
		ArrayList<Integer> curr = al.get(tar1);
		for(int i=0;i<curr.size();i++) {
			int next = curr.get(i);
			if(!visit[next]) {
				visit[next]=true;
				answer = dfs(answer,cnt+1, next, tar2);
			}
		}
		return answer;
	}
}

