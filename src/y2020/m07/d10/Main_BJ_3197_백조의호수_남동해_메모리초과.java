package y2020.m07.d10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_3197_백조의호수_남동해_메모리초과 {
	public static int map[][],R, C, swan[], di[] = { -1, 0, 1, 0 }, dj[] = { 0, 1, 0, -1 }, day;
	public static char lake[][];
	public static boolean visit[][];
	public static Queue<int[]> q;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_3197.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		lake = new char[R][C];
		map = new int[R][C];
		swan = new int[2];
		q = new LinkedList<int[]>();
		
		for(int i=0;i<R;i++) {
			String temp = br.readLine();
			for(int j=0;j<C;j++) {
				lake[i][j] = temp.charAt(j);
				map[i][j]=Integer.MAX_VALUE;
				if(lake[i][j]=='L') {
					swan[0]=i;
					swan[1]=j;
				}else if(lake[i][j]=='X') {
					q.add(new int[] {i,j,1});
				}
				
			}
//			System.out.println(Arrays.toString(lake[i]));
		}
		
		int a = 1;
		boolean esc = false;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(curr[2]!=a) {
//				System.out.println(a);
				esc = checkSwan(swan[0],swan[1],a);
				a=curr[2];
			}
			if(esc) {
//				System.out.println(curr[2]);
				break;
			}
			boolean flag = false;
			for(int d=0;d<4;d++){
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(ni>=0&&nj>=0&&ni<R&&nj<C&&(lake[ni][nj]=='.'||lake[ni][nj]=='L'||map[ni][nj]==curr[2]-1)) {
					flag = true;
					break;
				}
			}
			if(flag) {
				map[curr[0]][curr[1]]=curr[2];
			}else {
				q.add(new int[] {curr[0],curr[1],curr[2]+1});
			}
		}
		
		System.out.println(a-1);
		
//		System.out.println();
//		for(int i=0;i<R;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}
	private static boolean checkSwan(int x, int y, int day) {
		visit = new boolean[R][C];
		visit[x][y]=true;
		Queue<int[]> sq = new LinkedList<>();
		sq.add(new int[] {x,y});
		while(!sq.isEmpty()) {
			int curr[] = sq.poll();
			for(int d=0;d<4;d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(ni>=0&&nj>=0&&ni<R&&nj<C&&map[ni][nj]<day&&!visit[ni][nj]) {
					sq.add(new int[] {ni,nj});
					visit[ni][nj]=true;
				}else if(ni>=0&&nj>=0&&ni<R&&nj<C&&lake[ni][nj]=='L') {
					return true;
				}
			}
		}
		return false;
	}
}
