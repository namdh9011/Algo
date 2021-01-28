package y2020.m07.d18;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
풀이시간 : 100분
시간 : 92ms
메모리 : 13468KB
- dfs로 풀다가 범위를 확인하고 bfs로 방식을 바꿈.
- 3차원 방문배열을 활용함.
*/

public class Main_BJ_1938_통나무옮기기_남동해 {
	public static int N,result,bi,bj,bdir,ei,ej,edir,cnt,di[]= {-1,-1,-1,0,1,1,1,0},dj[]= {-1,0,1,1,1,0,-1,-1};
	public static char map[][];
	public static boolean visit[][][];
	public static Queue<int[]> q;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_BJ_1938.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N][3];
		q=new LinkedList<>();
		int temp = 0;
		int flagb = 0;
		int flage = 0;
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='B'&&flagb==0) {
					flagb++;
					temp=i*N+j;
					continue;
				}
				if(map[i][j]=='B'&&flagb==1) {
					flagb++;
					bi=i;
					bj=j;
					if(temp+1==i*N+j) {
						bdir=1;			//통나무 가로
					}else {
						bdir=2;			//통나무 세로
					}
					continue;
				}
				if(map[i][j]=='E'&&flage==0) {
					flage++;
					temp=i*N+j;
					continue;
				}
				if(map[i][j]=='E'&&flage==1) {
					ei=i;
					ej=j;
					flage++;
					if(temp+1==i*N+j) {
						edir=1;			//도착 가로
					}else {
						edir=2;			//도착 세로
					}
					continue;
				}
			}
		}
		
		visit[bi][bj][bdir]=true;
		bfs();
		System.out.println(result);
	}
	private static void bfs() {
		q.add(new int[] {bi,bj,bdir,0});
		while(!q.isEmpty()) {
			int curr[] = q.poll();
			if(curr[2]==1) {
				//U
				int ni = curr[0]-1;
				int nj = curr[1];
				int ndir = curr[2];
				if(ni==ei&&nj==ej&&ndir==edir) {
					result=curr[3]+1;
					return;
				}
				if(ni>=0&&nj-1>=0&&nj+1<N&&!visit[ni][nj][ndir]&&map[ni][nj]!='1'&&map[ni][nj-1]!='1'&&map[ni][nj+1]!='1') {
					visit[ni][nj][ndir]=true;
					q.add(new int[] {ni,nj,ndir,curr[3]+1});
				}
				//D
				ni = curr[0]+1;
				nj = curr[1];
				ndir = curr[2];
				if(ni==ei&&nj==ej&&ndir==edir) {
					result=curr[3]+1;
					return;
				}
				if(ni<N&&nj-1>=0&&nj+1<N&&!visit[ni][nj][ndir]&&map[ni][nj]!='1'&&map[ni][nj-1]!='1'&&map[ni][nj+1]!='1') {
					visit[ni][nj][ndir]=true;
					q.add(new int[] {ni,nj,ndir,curr[3]+1});
				}
				//L
				ni = curr[0];
				nj = curr[1]-1;
				ndir = curr[2];
				if(ni==ei&&nj==ej&&ndir==edir) {
					result=curr[3]+1;
					return;
				}
				if(nj>=0&&!visit[ni][nj][ndir]&&nj-1>=0&&map[ni][nj-1]!='1') {
					visit[ni][nj][ndir]=true;
					q.add(new int[] {ni,nj,ndir,curr[3]+1});
				}
				//R
				ni = curr[0];
				nj = curr[1]+1;
				ndir = curr[2];
				if(ni==ei&&nj==ej&&ndir==edir) {
					result=curr[3]+1;
					return;
				}
				if(nj<N&&!visit[ni][nj][ndir]&&nj+1<N&&map[ni][nj+1]!='1') {
					visit[ni][nj][ndir]=true;
					q.add(new int[] {ni,nj,ndir,curr[3]+1});
				}
				//T
				if(curr[0]==ei&&curr[1]==ej&&2==edir) {
					result=curr[3]+1;
					return;
				}
				if(!visit[curr[0]][curr[1]][2]) {
					boolean f=false;
					for(int d=0;d<8;d++) {
						ni = curr[0]+di[d];
						nj = curr[1]+dj[d];
						if(ni<0||nj<0||ni>=N||nj>=N||map[ni][nj]=='1') {
							f=true;
							break;
						}
					}
					if(!f) {
						visit[curr[0]][curr[1]][2]=true;
						q.add(new int[] {curr[0],curr[1],2,curr[3]+1});
					}
				}
			}else {
				//U
				int ni = curr[0]-1;
				int nj = curr[1];
				int ndir = curr[2];
				if(ni==ei&&nj==ej&&ndir==edir) {
					result=curr[3]+1;
					return;
				}
				if(ni>=0&&!visit[ni][nj][ndir]&&ni-1>=0&&map[ni-1][nj]!='1') {
					visit[ni][nj][ndir]=true;
					q.add(new int[] {ni,nj,ndir,curr[3]+1});
				}
				//D
				ni = curr[0]+1;
				nj = curr[1];
				ndir = curr[2];
				if(ni==ei&&nj==ej&&ndir==edir) {
					result=curr[3]+1;
					return;
				}
				if(ni<N&&!visit[ni][nj][ndir]&&ni+1<N&&map[ni+1][nj]!='1') {
					visit[ni][nj][ndir]=true;
					q.add(new int[] {ni,nj,ndir,curr[3]+1});
				}
				//L
				ni = curr[0];
				nj = curr[1]-1;
				ndir = curr[2];
				if(ni==ei&&nj==ej&&ndir==edir) {
					result=curr[3]+1;
					return;
				}
				if(nj>=0&&!visit[ni][nj][ndir]&&ni-1>=0&&ni+1<N&&map[ni][nj]!='1'&&map[ni-1][nj]!='1'&&map[ni+1][nj]!='1') {
					visit[ni][nj][ndir]=true;
					q.add(new int[] {ni,nj,ndir,curr[3]+1});
				}
				//R
				ni = curr[0];
				nj = curr[1]+1;
				ndir = curr[2];
				if(ni==ei&&nj==ej&&ndir==edir) {
					result=curr[3]+1;
					return;
				}
				if(nj<N&&!visit[ni][nj][ndir]&&ni+1<N&&ni-1>=0&&map[ni][nj]!='1'&&map[ni-1][nj]!='1'&&map[ni+1][nj]!='1') {
					visit[ni][nj][ndir]=true;
					q.add(new int[] {ni,nj,ndir,curr[3]+1});
				}
				//T
				if(curr[0]==ei&&curr[1]==ej&&1==edir) {
					result=curr[3]+1;
					return;
				}
				if(!visit[curr[0]][curr[1]][1]) {
					boolean f=false;
					for(int d=0;d<8;d++) {
						ni = curr[0]+di[d];
						nj = curr[1]+dj[d];
						if(ni<0||nj<0||ni>=N||nj>=N||map[ni][nj]=='1') {
							f=true;
							break;
						}
					}
					if(!f) {
						visit[curr[0]][curr[1]][1]=true;
						q.add(new int[] {curr[0],curr[1],1,curr[3]+1});
					}
				}
			}
		}
	}
}
