package y2020.m07.d16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
풀이시간 : 90분
시간 : 204ms
메모리 : 21948KB
- 문제에 예시가 없지만 Voyager 출력시에도 방향 표시해줘야함.
- 오타 때문에 30분가량 시간낭비
*/
public class Main_BJ_3987_보이저1호_남동해 {
	public static int visit[][],time, N, M, PR, PC, di[] = { -1, 0, 1, 0 }, dj[] = { 0, 1, 0, -1 };
	public static char space[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_3987.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		space = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				space[i][j] = s.charAt(j);
			}
		}
		st = new StringTokenizer(br.readLine());
		PR = Integer.parseInt(st.nextToken()) - 1;
		PC = Integer.parseInt(st.nextToken()) - 1;
		int resulttime = 0;
		int resultdir = 0;
		boolean f = false;
		for (int d = 0; d < 4; d++) {
			visit = new int[N][M];
			time = 1;
			f = solve(d);
			if(f) {
				resultdir=d;
				break;
			}
			if(time>resulttime) {
				resulttime=time;
				resultdir=d;
			}
		}
		
		char stdir = stDir(resultdir);
		if(f) {
			System.out.println(stdir);
			System.out.println("Voyager");
		}else {
			System.out.println(stdir);
			System.out.println(resulttime);
		}
	}

	private static char stDir(int resultdir) {
		if(resultdir==0) {
			return 'U';
		}else if(resultdir==1) {
			return 'R';
		}else if(resultdir==2) {
			return 'D';
		}else {
			return 'L';
		}
	}

	private static boolean solve(int d) {
		int i = PR;
		int j = PC;
		int dir = d;
		while (true) {
			int ni = i + di[dir];
			int nj = j + dj[dir];
			if (ni >= 0 && nj >= 0 && ni < N && nj < M) {
				if(visit[ni][nj]>=5) {
					return true;
				}
				if(space[ni][nj]=='/') {
					visit[ni][nj]++;
					if(dir==0) {
						dir=1;
					}else if(dir==1) {
						dir=0;
					}else if(dir==2) {
						dir=3;
					}else {
						dir=2;
					}
				}else if(space[ni][nj]=='\\') {
					visit[ni][nj]++;
					if(dir==0) {
						dir=3;
					}else if(dir==1) {
						dir=2;
					}else if(dir==2) {
						dir=1;
					}else {
						dir=0;
					}
				}else if(space[ni][nj]=='C'){
					return false;
				}
				time++;
				i = ni;
				j = nj;
			}else {
				return false;
			}
		}
	}
}
