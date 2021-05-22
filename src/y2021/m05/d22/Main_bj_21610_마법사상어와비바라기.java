package y2021.m05.d22;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
메모리 : 16660KB
시간 : 204ms

최적 메모리 : 11992KB
최적 시간 : 132ms
*/
/*
5 4
0 0 1 0 2
2 3 2 1 0
4 3 2 9 0
1 0 2 9 0
8 8 2 1 0
1 3
3 4
8 1
4 8
 */
public class Main_bj_21610_마법사상어와비바라기 {
	public static ArrayList<int[]> cloud;
	public static int map[][],N,M,command[][],di[] = {0,-1,-1,-1,0,1,1,1}, dj[] = {-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws Exception {
		_init();
		for(int i=0;i<M;i++) {
			moveCloud(i);
			rainBug();
			makeCloud();
		}
		int answer = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				answer+=map[i][j];
			}
		}
		System.out.println(answer);
	}
	private static void makeCloud() {
		boolean[][] visit = new boolean[N][N];
		for(int i=0;i<cloud.size();i++) {
			int[] curr = cloud.get(i);
			visit[curr[0]][curr[1]]=true;
		}
		cloud.clear();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>=2&&!visit[i][j]) {
					cloud.add(new int[] {i,j});
					map[i][j]-=2;
				}
			}
		}
	}
	private static void rainBug() {
		int n = cloud.size();
		for(int i=0;i<n;i++) {
			int[] curr = cloud.get(i);
			for(int d=0;d<4;d++) {
				int ni = curr[0]+di[d*2+1];
				int nj = curr[1]+dj[d*2+1];
				if(ni>=0&&nj>=0&&ni<N&&nj<N&&map[ni][nj]>0) {
					map[curr[0]][curr[1]]++;
				}
			}
		}
	}
	private static void moveCloud(int co) {
		int dir = command[co][0];
		int dis = command[co][1];
		int n = cloud.size();
		for(int i=0;i<n;i++) {
			int[] curr = cloud.get(i);
			curr[0] = curr[0]+di[dir]*(dis%N);
			curr[1] = curr[1]+dj[dir]*(dis%N);
			if(curr[0]<0) curr[0]+=N;
			if(curr[1]<0) curr[1]+=N;
			if(curr[0]>=N) curr[0]-=N;
			if(curr[1]>=N) curr[1]-=N;
			map[curr[0]][curr[1]]++;
		}
	}
	private static void _init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		cloud = new ArrayList<>();
		cloud.add(new int[] {N-1,0});
		cloud.add(new int[] {N-1,1});
		cloud.add(new int[] {N-2,0});
		cloud.add(new int[] {N-2,1});
		command = new int[M][2];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			command[i][0]=Integer.parseInt(st.nextToken())-1;
			command[i][1]=Integer.parseInt(st.nextToken());
		}
	}
}


