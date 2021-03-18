package y2021.m03.d19;

import java.util.*;
import java.io.*;
/*
5 4
2 3
1 1 E
5 4 W
1 L 1
1 F 3
2 F 7
 */
public class Main_bj_2174_로봇시뮬레이션 {
	public static int di[] = {-1,0,1,0}, dj[] = {0,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());	//가로
		int B = Integer.parseInt(st.nextToken());	//세로
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] robots = new int[N][3];
		int[][] map = new int[B][A];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			robots[i][1]=Integer.parseInt(st.nextToken())-1;
			robots[i][0]=Integer.parseInt(st.nextToken())-1;
			map[robots[i][0]][robots[i][1]]=i+1;
			robots[i][2]=st.nextToken().charAt(0);
			if(robots[i][2]=='S') {
				robots[i][2]=0;
			}else if(robots[i][2]=='W') {
				robots[i][2]=1;
			}else if(robots[i][2]=='N') {
				robots[i][2]=2;
			}else if(robots[i][2]=='E') {
				robots[i][2]=3;
			}
		}
		boolean flag = false;
		here:for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int rnum = Integer.parseInt(st.nextToken())-1;
			int com = st.nextToken().charAt(0);
			int count = Integer.parseInt(st.nextToken());
			if(com=='L') {
				robots[rnum][2]=(robots[rnum][2]-count%4);
				if(robots[rnum][2]<0) {
					robots[rnum][2]+=4;
				}
			}else if(com=='R') {
				robots[rnum][2]=(robots[rnum][2]+count)%4;
			}else {
				for(int j=0;j<count;j++) {
					int ni = robots[rnum][0]+di[robots[rnum][2]];
					int nj = robots[rnum][1]+dj[robots[rnum][2]];
					if(ni>=0&&nj>=0&&ni<B&&nj<A) {
						if(map[ni][nj]!=0) {
							int ro = rnum+1;
							System.out.println("Robot " + ro + " crashes into robot " + map[ni][nj]);
							flag = true;
							break here;
						}else {
							map[robots[rnum][0]][robots[rnum][1]]=0;
							robots[rnum][0]=ni;
							robots[rnum][1]=nj;
							map[ni][nj]=rnum+1;
						}
					}else {
						int ro = rnum+1;
						System.out.println("Robot " + ro + " crashes into the wall");
						flag = true;
						break here;
					}
				}
			}
		}
		if(!flag) {
			System.out.println("OK");
		}
	}
}
