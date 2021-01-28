package y2020.m07.d17;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
풀이시간 : 
시간 : 
메모리 : 

*/
public class Main_BJ_9663_NQueen {
	public static int N, count;
	public static boolean visit[][], col[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new boolean[N];
		visit = new boolean[N][N];
		count = 0;
		for (int i = 0; i < N; i++) {
			visit[0][i] = true;
			col[i] = true;
			dfs(1);
			col[i] = false;
			visit[0][i] = false;
		}
		System.out.println(count);

	}

	private static void dfs(int cnt) {
		if (cnt == N) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!col[i]) {
				boolean f = false;
				for (int d = 1; d < N; d++) {
					int ni = cnt - d;
					int nj = i - d;
					if (ni >= 0 && nj >= 0 && ni < N && nj < N && visit[ni][nj]) {
						f = true;
					}
				}
				for (int d = 1; d < N; d++) {
					int ni = cnt - d;
					int nj = i + d;
					if (ni >= 0 && nj >= 0 && ni < N && nj < N && visit[ni][nj]) {
						f = true;
					}
				}
				if (!f) {
					visit[cnt][i] = true;
					col[i]=true;
					dfs(cnt + 1);
					col[i]=false;
					visit[cnt][i] = false;
				}
			}
		}
	}
}
