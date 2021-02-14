package y2021.m02.d14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
6
3
3 4
2 5
5 3
3
3 D
15 L
17 D
 */

class Main_bj_3190_뱀 {
	public static int di[] = {0,1,0,-1},dj[] = {1,0,-1,0},dir=0,N,map[][],esc;
	public static Deque<int[]> snake;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=1;
		}
		int L = Integer.parseInt(br.readLine());
		map[0][0]=2;
		snake = new LinkedList<>();
		snake.add(new int[] {0,0});
		int currtime=0;
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int endtime = Integer.parseInt(st.nextToken());
			String movedir = st.nextToken();
			moveSnake(currtime,endtime);
			if(movedir.equals("D")) {
				dir=(dir+1)%4;
			}else {
				dir=(dir-1+4)%4;
			}
			if(esc!=0) {
				break;
			}
			currtime=endtime;
		}
		if(esc==0) {
			moveSnake(currtime,currtime+N);
		}
		System.out.println(esc);
	}
	private static void moveSnake(int currtime, int endtime) {
		for(int i=currtime+1;i<=endtime;i++) {
			int head[] = snake.peekFirst();
			int ni = head[0] + di[dir];
			int nj = head[1] + dj[dir];
			if(ni>=0&&nj>=0&&ni<N&&nj<N) {
				if(map[ni][nj]==1) {
					map[ni][nj]=2;
					snake.addFirst(new int[] {ni,nj});
				}else if(map[ni][nj]==0){
					map[ni][nj]=2;
					snake.addFirst(new int[] {ni,nj});
					int tail[] = snake.pollLast();
					map[tail[0]][tail[1]]=0;
				}else {
					esc=i;
					return;
				}
			}else {
				esc=i;
				return;
			}
		}
	}
}