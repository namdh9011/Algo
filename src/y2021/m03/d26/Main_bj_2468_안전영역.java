package y2021.m03.d26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
메모리 : 16224KB
시간 : 192ms

최적 메모리 : 16192KB
최적 시간 : 136ms

*/

/*
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
 */
public class Main_bj_2468_안전영역 {
	public static int di[] = {-1,1,0,0}, dj[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st;
		int max = -1;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>max) {
					max = map[i][j];
				}
			}
		}
		int answer = 1;
		for(int high=0;high<max;high++) {
			int count = 0;
			boolean[][] visit = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visit[i][j]&&map[i][j]>high) {
						visit[i][j]=true;
						dfs(N,visit,map,high,i,j);
						count++;
					}
				}
			}
			if(answer<count) {
				answer = count;
			}
		}
		System.out.println(answer);
	}

	private static void dfs(int N, boolean[][] visit, int[][] map, int high, int i, int j) {
		for(int d=0;d<4;d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0&&nj>=0&&ni<N&&nj<N&&!visit[ni][nj]&&map[ni][nj]>high) {
				visit[ni][nj]=true;
				dfs(N,visit,map,high,ni,nj);
			}
		}
	}
}
