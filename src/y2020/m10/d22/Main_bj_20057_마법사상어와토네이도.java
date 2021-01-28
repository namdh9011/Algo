package y2020.m10.d22;
/*
풀이시간 : 90분
시간 : 440ms
메모리 : 36104KB
- 
*/
/*
5
0 0 0 0 0
0 0 0 0 0
0 100 0 0 0
0 0 0 0 0
0 0 0 0 0
 */
import java.util.*;
import java.io.*;
public class Main_bj_20057_마법사상어와토네이도 {
	public static int di[]= {0,1,0,-1},dj[]= {-1,0,1,0},x,y,map[][],N;
	public static int ddi[][] = {{-1,1,-1,1,0,-2,2,-1,1,0},{1,1,0,0,2,0,0,-1,-1,1},{-1,1,-1,1,0,-2,2,-1,1,0},{-1,-1,0,0,-2,0,0,1,1,-1}},
					  ddj[][] = {{-1,-1,0,0,-2,0,0,1,1,-1},{1,-1,1,-1,0,2,-2,1,-1,0},{1,1,0,0,2,0,0,-1,-1,1},{-1,1,-1,1,0,-2,2,-1,1,0}};
	public static double ddp[] = {0.1,0.1,0.07,0.07,0.05,0.02,0.02,0.01,0.01,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int result = 0;
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				result+=map[i][j];
			}
		}
		
		int temp = 0;
		x=N/2;
		y=N/2;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<2;j++) {
				moveTornado(temp%4,i);
				temp++;
				if(x<0||y<0) {
					break;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				result-=map[i][j];
			}
		}
		System.out.println(result);
	}
	public static void moveTornado(int dir, int count) {
		for(int i=1;i<=count;i++) {
			int ni = x+di[dir];
			int nj = y+dj[dir];
			if(ni>=0&&nj>=0&&ni<N&&nj<N) {
				spreadSand(dir,ni,nj);
				x = ni;
				y = nj;
			}else {
				x = ni;
				y = nj;
				return;
			}
		}
	}
	public static void spreadSand(int dir, int r, int c) {
		double curr = map[r][c];
		int temp = map[r][c];
		for(int d=0;d<ddi[0].length-1;d++) {
			int ni = r+ddi[dir][d];
			int nj = c+ddj[dir][d];
			if(ni>=0&&nj>=0&&ni<N&&nj<N) {
				int t = (int)(curr*ddp[d]);
				map[ni][nj]+=t;
				temp -= t;
			}else {
				temp-=(int) (curr*ddp[d]);
			}
		}
		int ni = r+ddi[dir][9];
		int nj = c+ddj[dir][9];
		if(ni>=0&&nj>=0&&ni<N&&nj<N) {
			map[ni][nj]+=temp;
		}
		map[r][c]=0;
	}
}
