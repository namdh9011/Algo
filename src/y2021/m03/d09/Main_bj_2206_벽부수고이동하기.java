package y2021.m03.d09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
6 4
0100
1110
1000
0000
0111
0000
 */
/*
5 10
0000011000
1101011010
0000000010
1111111110
1111000000
 */

class Main_bj_2206_벽부수고이동하기 {
	public static int map[][], N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=input.charAt(j)-48;
			}
		}
		int answer = bfs();
		System.out.println(answer);
	}
	private static int bfs() {
		if(N==1&&M==1) {
			return 1;
		}
		boolean[][][] visit = new boolean[N][M][2];
		Queue<int[]> q = new LinkedList<>();
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		q.add(new int[] {0,0,1,0});		// i,j,거리,벽뚫기
		visit[0][0][0]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<di.length;d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(ni>=0&&nj>=0&&ni<N&&nj<M) {
					if(ni==N-1&&nj==M-1) {
						return curr[2]+1;
					}
					if(curr[3]==0) {
						if(map[ni][nj]==0&&!visit[ni][nj][0]) {
							visit[ni][nj][0]=true;
							q.add(new int[] {ni,nj,curr[2]+1,curr[3]});
						}else if(map[ni][nj]==1&&!visit[ni][nj][1]) {
							visit[ni][nj][1]=true;
							q.add(new int[] {ni,nj,curr[2]+1,1});
						}
					}else {
						if(!visit[ni][nj][1]) {
							if(map[ni][nj]==0&&!visit[ni][nj][1]) {
								visit[ni][nj][1]=true;
								q.add(new int[] {ni,nj,curr[2]+1,curr[3]});
							}
						}
					}
				}
			}
		}
		return -1;
	}
}