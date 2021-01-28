package y2020.m10.d22;
import java.io.*;
import java.util.*;
/*
풀이시간 : 60분
시간 : 300ms
메모리 : 37220KB
- 
*/
/*
3 1
1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1
1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1
1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1
1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1
1
 */
public class Main_bj_20058_마법사상어와파이어스톰 {
	public static int max,result, map[][],N,Q,L[],di[] = {-1,1,0,0},dj[] = {0,0,-1,1};
	public static boolean v[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
		Q = Integer.parseInt(st.nextToken());
		L = new int[Q];
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				result += map[i][j];
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<Q;i++) {
			L[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<Q;i++) {
			spinMap(L[i]);
			meltIce();
		}
		
		v=new boolean[N][N];
		max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0&&!v[i][j]) {
					v[i][j]=true;
					bfs(i,j);
				}
			}
		}
		System.out.println(result);
		System.out.println(max);
	}
	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		int count = 1;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<di.length;d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(ni>=0&&nj>=0&&ni<N&&nj<N&&map[ni][nj]!=0&&!v[ni][nj]) {
					v[ni][nj]=true;
					q.add(new int[] {ni, nj});
					count++;
				}
			}
		}
		if(count>max) {
			max = count;
		}
	}
	public static void meltIce() {
		boolean visit[][] = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int count = 0;
				for(int d=0;d<di.length;d++) {
					int ni = i + di[d];
					int nj = j + dj[d];
					if(ni>=0&&nj>=0&&ni<N&&nj<N) {
						if(map[ni][nj]!=0) {
							count++;
						}
					}
				}
				if(count<3&&map[i][j]>0) {
					visit[i][j]=true;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visit[i][j]) {
					map[i][j]--;
					result--;
				}
			}
		}
	}
	public static void spinMap(int ran) {
		int range =(int)(Math.pow(2,ran));
		int[][] tempmap = new int[N][N];
		for(int i=0;i<N;i+=range) {
			for(int j=0;j<N;j+=range) {
				for(int k=0;k<range;k++) {
					for(int l=0;l<range;l++) {
						tempmap[i+l][j+range-k-1]=map[i+k][j+l];
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=tempmap[i][j];
			}
		}
	}
}
