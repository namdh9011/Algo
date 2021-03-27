package y2021.m03.d27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
메모리 : 292456KB
시간 : 504ms

최적 메모리 : 39436KB
최적 시간 : 160ms

- 틀리진 않았지만 최적을 찾아볼 필요가 있음.
*/
/*
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW
 */
public class Main_bj_2589_보물섬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=input.charAt(j);
			}
		}
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]=='L') {
					max = Math.max(bfs(N,M,map,i,j),max);
				}
			}
		}
		System.out.println(max);
	}

	private static int bfs(int N, int M, char[][] map, int i, int j) {
		int answer = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		q.add(new int[] {i,j,0});
		visit[i][j]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<4;d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(ni>=0&&nj>=0&&ni<N&&nj<M&&!visit[ni][nj]&&map[ni][nj]=='L') {
					visit[ni][nj]=true;
					q.add(new int[] {ni,nj,curr[2]+1});
					if(curr[2]+1>answer) {
						answer = curr[2]+1;
					}
				}
			}
		}
		return answer;
	}
}
