package y2020.m07.d06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17070_파이프옮기기1_남동해 {
	public static int N,room[][],result,di[]= {0,1,1},dj[]= {1,0,1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_17070.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		room = new int[N][N];
		result=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				room[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0,1);
		System.out.println(result);
	}
	private static void dfs(int dir, int i, int j) {
		if(i==N-1&&j==N-1) {
			result++;
			return;
		}
		if(dir==0) {		//가로
			int ni = i+di[0];
			int nj = j+dj[0];
			if(ni<N&&nj<N&&room[ni][nj]==0) {
				dfs(0,ni,nj);
			}
			ni = i+di[2];
			nj = j+dj[2];
			if(ni<N&&nj<N&&room[ni][nj]==0&&room[ni-1][nj]==0&&room[ni][nj-1]==0) {
				dfs(2,ni,nj);
			}
		}else if(dir==1) {	//세로
			int ni = i+di[1];
			int nj = j+dj[1];
			if(ni<N&&nj<N&&room[ni][nj]==0) {
				dfs(1,ni,nj);
			}
			ni = i+di[2];
			nj = j+dj[2];
			if(ni<N&&nj<N&&room[ni][nj]==0&&room[ni-1][nj]==0&&room[ni][nj-1]==0) {
				dfs(2,ni,nj);
			}
		}else {				//대각선
			for(int d=0;d<2;d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni<N&&nj<N&&room[ni][nj]==0) {
					dfs(d,ni,nj);
				}
			}
			int ni = i+di[2];
			int nj = j+dj[2];
			if(ni<N&&nj<N&&room[ni][nj]==0&&room[ni-1][nj]==0&&room[ni][nj-1]==0) {
				dfs(2,ni,nj);
			}
		}
	}
}
