package y2021.m03.d10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1
 */

class Main_bj_7562_나이트의이동 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			int I = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken());
			int sj = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int ei = Integer.parseInt(st.nextToken());
			int ej = Integer.parseInt(st.nextToken());
			sb.append(bfs(I,si,sj,ei,ej)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int bfs(int N, int si, int sj, int ei, int ej) {
		if(si==ei&&sj==ej) {
			return 0;
		}
		boolean[][] visit = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		int[] di = {-2,-2,-1,-1,1,1,2,2};
		int[] dj = {-1,1,-2,2,-2,2,-1,1};
		q.add(new int[] {si,sj,0});
		visit[si][sj]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<di.length;d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(ni>=0&&nj>=0&&ni<N&&nj<N&&!visit[ni][nj]) {
					if(ni==ei&&nj==ej) {
						return curr[2]+1;
					}
					visit[ni][nj]=true;
					q.add(new int[] {ni,nj,curr[2]+1});
				}
			}
		}
		return -1;
	}
}