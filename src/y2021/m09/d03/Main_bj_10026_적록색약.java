package y2021.m09.d03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
메모리 : 12136 KB
시간 : 96 ms

최적 메모리 : 13524 KB
최적 시간 : 76 ms
*/
/*
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
 */
public class Main_bj_10026_적록색약 {
	public static int N,di[]= {-1,0,1,0}, dj[]= {0,-1,0,1}, res, resDif;
	public static boolean visit[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		char[][] mapDif = new char[N][N];
		visit = new boolean[N][N];
		res=0;
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=input.charAt(j);
				mapDif[i][j]=input.charAt(j);
				if(mapDif[i][j]=='R') {
					mapDif[i][j]='G';
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					visit[i][j]=true;
					res++;
					dfs(i,j,map[i][j],map);
				}
			}
		}
		visit = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					visit[i][j]=true;
					resDif++;
					dfs(i,j,mapDif[i][j],mapDif);
				}
			}
		}
		System.out.println(res + " " + resDif);
	}
	private static void dfs(int x, int y, char tar,char[][] map) {
		for(int d=0;d<4;d++) {
			int ni = x + di[d];
			int nj = y + dj[d];
			if(ni>=0&&nj>=0&&ni<N&&nj<N&&!visit[ni][nj]&&map[ni][nj]==tar) {
				visit[ni][nj]=true;
				dfs(ni,nj,tar,map);
			}
		}
	}
}


