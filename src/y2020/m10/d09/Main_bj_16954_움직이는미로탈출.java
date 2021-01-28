package y2020.m10.d09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
풀이시간 : 30분
시간 : 296ms
메모리 : 173620KB
-
*/
/*
........
........
........
........
........
........
........
........
 */
public class Main_bj_16954_움직이는미로탈출 {
	public static char map[][];
	public static int N,di[]= {-1,-1,0,1,1,1,0,-1},dj[]= {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=8;
		map = new char[N][N];
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			map[i] = temp.toCharArray();
		}
		if(bfs()) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	private static boolean bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {7,0,0});
		int time = 0;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(time!=curr[2]) {
				time = curr[2];
				moveMap();
			}
			if(map[curr[0]][curr[1]]=='#') {
				continue;
			}
			q.add(new int[] {curr[0],curr[1],curr[2]+1});
			for(int d=0;d<8;d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(ni>=0&&nj>=0&&ni<N&&nj<N&&map[ni][nj]=='.') {
					if(ni==0&&nj==7) {
						return true;
					}
					q.add(new int[] {ni,nj,curr[2]+1});
				}
			}
		}
		return false;
	}
	private static void moveMap() {
		for(int i=N-2;i>=0;i--) {
			for(int j=0;j<N;j++) {
				map[i+1][j]=map[i][j];
			}
		}
		for(int i=0;i<N;i++) {
			map[0][i]='.';
		}
	}
}
