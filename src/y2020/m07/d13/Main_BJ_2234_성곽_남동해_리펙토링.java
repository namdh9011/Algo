package y2020.m07.d13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
풀이시간 : 65분
시간 : 96ms
메모리 : 13672KB
*/

public class Main_BJ_2234_성곽_남동해_리펙토링 {
	public static int N,M,data[][],map[][],bfsdir[]= {1,2,4,8},colordata[],answer3,di[]= {0,-1,0,1},dj[]= {-1,0,1,0},max_size;
	public static boolean visit[][];
	public static Queue<int[]> q;
	public static Queue<Integer> colorInfo;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_2234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		data = new int[N][M];
		map = new int[N][M];
		visit = new boolean[N][M];
		q = new LinkedList<int[]>();
		colorInfo = new LinkedList<Integer>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				data[i][j]=15-Integer.parseInt(st.nextToken());
			}
		}
		
		int color = 1;
		// 0,1,2,3 서,북,동,남
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visit[i][j]) {
					visit[i][j]=true;
					map[i][j]=color;
					int a = bfs(i,j,color);
					colorInfo.add(a);
					if(a>max_size) {
						max_size = a;
					}
					color++;
				}
			}
		}
		int cosize = colorInfo.size();
		colordata = new int[cosize+1];
		for(int i=1;i<=cosize;i++) {
			colordata[i]=colorInfo.poll();
		}
		checkAnswer3();
		
		System.out.println(color-1);//출력
		System.out.println(max_size);//출력
		System.out.println(answer3);//출력
		
	}
	private static void checkAnswer3() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int d=0;d<4;d++) {
					int ni = i+di[d];
					int nj = j+dj[d];
					if(ni>=0&&nj>=0&&ni<N&&nj<M&&map[i][j]!=map[ni][nj]) {
						int te = colordata[map[i][j]]+colordata[map[ni][nj]];
						if(answer3<te) {
							answer3 = te;
						}
					}
				}
			}
		}
	}
	private static int bfs(int i, int j, int color) {
		q.add(new int[] {i,j});
		int size = 1;
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			for(int d=3;d>=0;d--) {
				int dir = bfsdir[d];
				if(data[x][y]>=dir) {
					int ni = x+di[d];
					int nj = y+dj[d];
					if(ni>=0&&nj>=0&&ni<N&&nj<M&&!visit[ni][nj]) {
						visit[ni][nj]=true;
						map[ni][nj]=color;
						size++;
						q.add(new int[] {ni,nj});
					}
					data[x][y]=data[x][y]-dir;
				}
			}
		}
		return size;
	}
}
