package y2021.m03.d08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
4 6
101111
101010
101011
111011
 */


class Main_bj_2178_미로탐색 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=input.charAt(j)-48;
			}
		}
		int answer = bfs(map,N,M);
		System.out.println(answer);
	}

	private static int bfs(int[][] map,int N,int M) {
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,1});
		visit[0][0]=true;
		int[] di = {-1,0,1,0}; 
		int[] dj = {0,1,0,-1}; 
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<di.length;d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(ni>=0&&nj>=0&&ni<N&&nj<M&&map[ni][nj]==1&&!visit[ni][nj]) {
					if(ni==N-1&&nj==M-1) {
						return curr[2]+1;
					}
					q.add(new int[] {ni,nj,curr[2]+1});
					visit[ni][nj]=true;
				}
			}
		}
		return 0;
	}
}