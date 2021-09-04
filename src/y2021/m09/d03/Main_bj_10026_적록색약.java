package y2021.m09.d03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
메모리 : 12232 KB
시간 : 964 ms

최적 메모리 : 12040 KB
최적 시간 : 124 ms

- 백트래킹 해줘야 할듯.
*/
/*
5 5
IEFCJ
FHFKC
FFALF
HFGCF
HMCHH
 */
public class Main_bj_10026_적록색약 {
	public static int R, C, di[] = {-1,1,0,0}, dj[]= {0,0,-1,1}, max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[26];
		max = Integer.MIN_VALUE;
		
		char[][] board = new char[R][C];
		for(int i=0;i<R;i++) {
			String input = br.readLine();
			for(int j=0;j<C;j++) {
				board[i][j]=input.charAt(j);
			}
		}
		
		char tar = board[0][0];
		visit[tar-'A']=true;
		dfs(0,0,board,visit,1);
		System.out.println(max);
	}

	private static void dfs(int i, int j, char[][] board, boolean[] visit, int count) {
		if(max<count) {
			max=count;
		}
		for(int d=0;d<4;d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0&&nj>=0&&ni<R&&nj<C) {
				int tar = board[ni][nj];
				if(!visit[tar-'A']) {
					visit[tar-'A']=true;
					dfs(ni,nj,board,visit, count+1);
					visit[tar-'A']=false;
				}
			}
		}
	}
}


