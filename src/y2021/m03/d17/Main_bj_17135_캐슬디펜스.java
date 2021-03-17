package y2021.m03.d17;

import java.util.*;
import java.io.*;
/*
6 5 1
1 0 1 0 1
0 1 0 1 0
1 1 0 0 0
0 0 0 1 1
1 1 0 1 1
0 0 1 0 0
 */
public class Main_bj_17135_캐슬디펜스 {
	public static int map[][],N,M,D,di[] ={-1,0,0},dj[]={0,-1,1},answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int[] arr = new int[3];
		boolean[] visit = new boolean[M];
		comb(arr, 0, 0, visit);
		System.out.println(answer);
	}
	public static void comb(int[] arr, int count, int start, boolean[] visit) {
		if(count==3) {
			int dead = defence(arr);		//arr = archer의 위치
			if(answer<dead) {				//죽은 숫자 갱신
				answer=dead;
			}
			return;
		}
		for(int i=start;i<M;i++) {
			if(!visit[i]) {
				visit[i]=true;
				arr[count]=i;
				comb(arr,count+1,i,visit);
				visit[i]=false;
			}
		}
	}
	public static int defence(int[] archer) {		
		int dead = 0;
		int[][] tmap = new int[N][M];
		for(int i=0;i<tmap.length;i++) {
			tmap[i]=map[i].clone();
		}
		for(int line=N-1;line>=0;line--) {
			Queue<int[]> remove = new LinkedList<>();
			for(int i=0;i<archer.length;i++) {
				int arc = archer[i];
				if(tmap[line][arc]==1) {					//궁수 바로 위칸이 1이면
					remove.add(new int[] {line, arc});
				}else {										//궁수 바로 위칸이 0이면
					if(D>1) {								//사거리가 1보다 길때
						boolean[][] visit = new boolean[N][M];
						Queue<int[]> q = new LinkedList<>();
						
						PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {		//왼쪽 타겟 제거용 pq
							public int compare(int[] o1, int[] o2) {
									return o1[1]-o2[1];
							}
						});
						q.add(new int[] {line, arc, 1});
						visit[line][arc]=true;
						int esc = D;							//탈출 조건
						while(!q.isEmpty()) {
							int[] curr = q.poll();
							for(int d=0;d<3;d++) {
								int ni = curr[0]+di[d];
								int nj = curr[1]+dj[d];
								if(ni>=0&&nj>=0&&ni<N&&nj<M&&!visit[ni][nj]&&curr[2]+1<=esc) {
									visit[ni][nj]=true;
									q.add(new int[] {ni,nj,curr[2]+1});
									if(tmap[ni][nj]==1) {		//제거 대상을 만날 경우
										pq.add(new int[] {ni,nj,curr[2]+1});
										esc=curr[2]+1;			//탈출 조건을 지정해서 같은 거리에 있는 타겟을 모두 넣어줄 수 있게한다.
									}
								}
							}
						}
						if(pq.size()>0) {
							int[] temp = pq.poll();
							remove.add(new int[] {temp[0], temp[1]});
						}
					}
				}
			}
			while(!remove.isEmpty()) {
				int[] curr = remove.poll();
				if(tmap[curr[0]][curr[1]]==1) {		//제거 대상이 겹치지 않을때만 제거해주고 죽은 수를 늘려줌
					tmap[curr[0]][curr[1]]=0;
					dead++;
				}
			}
		}
		return dead;
	}
}
