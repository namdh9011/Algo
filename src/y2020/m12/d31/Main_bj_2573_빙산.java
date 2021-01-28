package y2020.m12.d31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5 7
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0
*/

class Main_bj_2573_빙산 {
    public static int N,M,map[][],di[]= {-1,0,1,0},dj[] = {0,-1,0,1};
    public static boolean visit[][],meltall;
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			map[i][j]=Integer.parseInt(st.nextToken());
    		}
    	}
    	int answer = 0;
    	int year = 0;
    	meltall=false;
    	while(true) {
    		if(checkMap()) {
    			answer=year;
    			break;
    		}
    		year++;
    		meltIce();
    	}
    	if(meltall) {
    		System.out.println(0);
    	}else {
    		System.out.println(answer);
    	}
	}
	private static void meltIce() {
		int[][] tempmap = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>0) {
					for(int d=0;d<4;d++) {
						int ni = i+di[d];
						int nj = j+dj[d];
						if(ni>=0&&nj>=0&&ni<N&&nj<M&&map[ni][nj]==0) {
							tempmap[i][j]++;
						}
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]-=tempmap[i][j];
				if(map[i][j]<0) {
					map[i][j]=0;
				}
			}
		}
	}
	private static boolean checkMap() {
		visit = new boolean[N][M];
		boolean flag=false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>0&&!visit[i][j]) {
					if(flag) {
						return true;
					}
					visitMap(i,j);
					flag=true;
				}
			}
		}
		if(!flag) {
			meltall=true;
			return true;
		}
		return false;
	}
	private static void visitMap(int i, int j) {
		for(int d=0;d<4;d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0&&nj>=0&&ni<N&&nj<M&&map[ni][nj]>0&&!visit[ni][nj]) {
				visit[ni][nj]=true;
				visitMap(ni,nj);
			}
		}
	}
}
