package y2020.m07.d14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
풀이시간 : --
시간 : 80ms
메모리 : 13252KB
*/

public class Main_BJ_19236_청소년상어_남동해 {
	public static int N = 4,sharkSize,fish[][],shark[],map[][][],di[]= {0,-1,-1,0,1,1,1,0,-1},dj[]= {0,0,-1,-1,-1,0,1,1,1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_19236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		fish = new int[17][3];
		shark = new int[3];
		map = new int[N][N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[i][j][0]=num;	//map의 물고기넘버
				map[i][j][1]=dir;	//map의 물고기방향
				fish[num][0]=i;
				fish[num][1]=j;
				fish[num][2]=dir;
			}
		}
		
		sharkSize = map[0][0][0];
		shark[0]=0;
		shark[1]=0;					//상어 초기좌표
		shark[2]=map[0][0][1];		//상어 초기방향
		fish[map[0][0][0]][0]=0;
		fish[map[0][0][0]][1]=0;
		fish[map[0][0][0]][2]=0;	//상어가 들어간 자리 물고기정보 제거
		map[0][0][0]=-1;
		map[0][0][1]=0;
		moveFish();
		dfs(shark[0],shark[1],shark[2],sharkSize);
		System.out.println(sharkSize);
	}

	private static void dfs(int i, int j, int dir, int size) {
		for(int d=1;d<=3;d++) {
			int ni = i+di[dir]*d;
			int nj = j+dj[dir]*d;
			if(ni>=0&&nj>=0&&ni<N&&nj<N&&map[ni][nj][0]>0) {
				int ndir = map[ni][nj][1];
				int tempnum = map[ni][nj][0];
				int[][][] tempmap = new int[4][4][2];
				int[][] tempfish = new int[17][3];
				for(int t=0;t<N;t++) {
					for(int u=0;u<N;u++) {
						tempmap[t][u][0]=map[t][u][0];
						tempmap[t][u][1]=map[t][u][1];
					}
				}
				for(int t=1;t<17;t++) {
					tempfish[t] = fish[t].clone();
				}
				if(sharkSize<tempnum+size) {
					sharkSize=tempnum+size;
				}
				map[i][j][0]=0;
				map[i][j][1]=0;
				map[ni][nj][0]=-1;
				map[ni][nj][1]=0;
				fish[tempnum][0]=0;
				fish[tempnum][1]=0;
				fish[tempnum][2]=0;
				moveFish();
				dfs(ni,nj,ndir,tempnum+size);
				for(int t=0;t<N;t++) {
					for(int u=0;u<N;u++) {
						map[t][u][0]=tempmap[t][u][0];
						map[t][u][1]=tempmap[t][u][1];
					}
				}
				for(int t=1;t<17;t++) {
					fish[t] = tempfish[t].clone();
				}
			}
		}
	}

	private static void moveFish() {
		for(int i=1;i<=16;i++) {
			int x = fish[i][0];
			int y = fish[i][1];
			int dir = fish[i][2];
			
			if(dir!=0) {
				for(int d=0;d<8;d++) {
					int ndir = dir+d;
					if(ndir>8) {
						ndir=ndir-8;
					}
					int ni = x + di[ndir];
					int nj = y + dj[ndir];
					if(ni>=0&&nj>=0&&ni<N&&nj<N&&map[ni][nj][0]>=0) {
						int nfishnum = map[ni][nj][0];
//						fish[i][0]=fish[nfishnum][0];	//틀린부분
//						fish[i][1]=fish[nfishnum][1]; 	//틀린부분
						fish[i][0]=ni;
						fish[i][1]=nj;
						fish[i][2]=ndir;
						fish[nfishnum][0]=x;
						fish[nfishnum][1]=y;
						
						int tempnum = map[ni][nj][0];
						int tempdir = map[ni][nj][1];
						map[ni][nj][0]=map[x][y][0];
						map[ni][nj][1]=ndir;
						map[x][y][0]=tempnum;
						map[x][y][1]=tempdir;
						break;
					}
				}
			}
		}
	}
}
