package y2021.m09.d04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
메모리 : 11940 KB
시간 : 88 ms

최적 메모리 : 14400 KB
최적 시간 : 76 ms
*/
/*
5 7 3
0 0 4 4
1 1 2 5
4 0 7 5
 */
public class Main_bj_2583_영역구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		ArrayList<Integer> res = new ArrayList<>();
		
		boolean[][] map = new boolean[N][M];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int xs = Integer.parseInt(st.nextToken());
			int ys = Integer.parseInt(st.nextToken());
			int xe = Integer.parseInt(st.nextToken());
			int ye = Integer.parseInt(st.nextToken());
			initMap(map, xs, ys, xe, ye);
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!map[i][j]) {
					count++;
					map[i][j]=true;
					res.add(bfs(map, N, M, i, j));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(count).append("\n");
		Collections.sort(res);
		for(int i=0;i<res.size();i++) {
			sb.append(res.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	public static int bfs(boolean[][] map, int N, int M, int i, int j) {
		int cnt = 1;
		int[] di = {-1,1,0,0};
		int[] dj = {0,0,-1,1};
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		while(!q.isEmpty()) {
			int curr[] = q.poll();
			for(int d=0;d<di.length;d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(ni>=0&&nj>=0&&ni<N&&nj<M&&!map[ni][nj]) {
					cnt++;
					map[ni][nj]=true;
					q.add(new int[] {ni, nj});
				}
			}
		}
		return cnt;
	}
	
	public static void initMap(boolean[][] map, int xs, int ys, int xe, int ye) {
		for(int i=ys; i<ye; i++) {
			for(int j=xs; j<xe; j++) {
				map[i][j]=true;
			}
		}
	}
}


