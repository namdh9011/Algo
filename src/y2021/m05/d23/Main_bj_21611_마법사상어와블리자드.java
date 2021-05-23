package y2021.m05.d23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
메모리 : 33152KB
시간 : 264ms

최적 메모리 : 15072KB
최적 시간 : 152ms
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
public class Main_bj_21611_마법사상어와블리자드 {
	public static int size,N,M,data[][],command[][],map[],di[] = {0,1,0,-1}, dj[] = {1,0,-1,0}, smagic[]= {8,4,2,6}, answer[];
	public static void main(String[] args) throws Exception {
		init();
		answer = new int[4];
		for(int i=0;i<M;i++) {
			blizzard(command[i]);
			dropStone();
			while(true) {
				int esc = bombStone();
				if(esc==0) {
					break;
				}
				dropStone();
			}
			addStone();
		}
		int result = 0;
		for(int i=1;i<=3;i++) {
			result+=i*answer[i];
		}
		System.out.println(result);
	}
	private static void addStone() {
		Queue<int[]> q = new LinkedList<>();
		int tar = map[2];
		if(tar==0) {
			return;
		}
		int count = 1;
		for(int i=3;i<size;i++) {
			if(map[i]==0) {
				break;
			}
			if(tar==map[i]) {
				count++;
			}else {
				q.add(new int[] {count,tar});
				tar=map[i];
				count=1;
			}
		}
		q.add(new int[] {count,tar});
		int si = 2;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			map[si++]=curr[0];
			if(si>=size) {
				break;
			}
			map[si++]=curr[1];
			if(si>=size) {
				break;
			}
		}
		for(int i=si;i<size;i++) {
			map[i]=0;
		}
	}
	private static int bombStone() {
		int esc = 0;
		
		int tar = map[2];
		if(tar==0) {
			return 0;
		}
		int count = 1;
		ArrayList<Integer> bomb = new ArrayList<>();
		for(int i=3;i<size;i++) {
			if(map[i]==0) {
				break;
			}
			if(tar==map[i]) {
				count++;
			}else {
				tar=map[i];
				count=1;
			}
			if(count==4) {
				bomb.add(i);
				esc++;
			}
		}
		for(int i=0;i<bomb.size();i++) {
			int d = bomb.get(i);
			tar = map[d];
			answer[tar]++;
			map[d]=0;
			for(int j=d+1;j<size;j++) {
				if(tar==map[j]) {
					answer[map[j]]++;
					map[j]=0;
				}else {
					break;
				}
			}
			for(int j=d-1;j>=2;j--) {
				if(tar==map[j]) {
					answer[map[j]]++;
					map[j]=0;
				}else {
					break;
				}
			}
		}
		return esc;
	}
	private static void dropStone() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=2;i<size;i++) {
			if(map[i]!=0) {
				q.add(map[i]);
			}
		}
		int start = 2;
		while(!q.isEmpty()) {
			map[start]=q.poll();
			start++;
		}
		for(int i=start;i<size;i++) {
			map[i]=0;
		}
	}
	private static void blizzard(int[] com) {
		int d = com[0];
		int s = com[1];
		int tar = 1;
		for(int i=0;i<s;i++) {
			tar+=8*i+(smagic[d]-1);
			map[tar]=0;
		}
	}
	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N][N];
		size = N*N+1;
		map = new int[size];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				data[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		mapDraw();
		command=new int[M][2];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			command[i][0]=Integer.parseInt(st.nextToken())-1;
			command[i][1]=Integer.parseInt(st.nextToken());
		}
	}
	private static void mapDraw() {
		int d = 0;
		int x = 0;
		int y = 0;
		boolean[][] visit = new boolean[N][N];
		for(int i=size-1;i>0;i--) {
			map[i]=data[x][y];
			visit[x][y]=true;
			int ni = x+di[d];
			int nj = y+dj[d];
			if(ni<0||nj<0||ni>=N||nj>=N||visit[ni][nj]) {
				d++;
				d%=4;
				x=x+di[d];
				y=y+dj[d];
			}else {
				x=ni;
				y=nj;
			}
		}
	}
}


