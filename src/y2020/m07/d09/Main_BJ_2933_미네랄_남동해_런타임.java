package y2020.m07.d09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*

입력:
5 5
.....
x.xxx
x.x..
xxx..
x....
2
5 3

출력:
.....
x....
x....
xxx..
x.xxx


출력(정답):
.....
x....
x.xxx
xxx..
x....

*/
public class Main_BJ_2933_미네랄_남동해_런타임 {
	public static int R, C, N, spear[], di[] = { -1, 0, 1, 0 }, dj[] = { 0, 1, 0, -1 };
	public static char cave[][];
	public static Queue<Integer> ice, dropice;
	public static boolean visit[];

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_BJ_2933.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		cave = new char[R][C];
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				cave[i][j] = temp.charAt(j);
			}
		}

		N = Integer.parseInt(br.readLine());
		spear = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			spear[i] = Integer.parseInt(st.nextToken());
		}

		ice = new LinkedList<>();
		dropice = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			throwSpear(i);
			searchCluster();
//			for (int j = 0; j < R; j++) {
//				System.out.println(Arrays.toString(cave[j]));
//			}
//			System.out.println();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(cave[i][j]);
			}
			System.out.println();
		}
	}

	private static void dropCluster() {
		int min = R;

		while (!dropice.isEmpty()) {
			int dropcount = 0;
			int temp = dropice.poll();
			ice.add(temp);
			int x = temp / C;
			int y = temp % C;
			for (int i = x + 1; i < R; i++) {
				if (!visit[C * i + y] && cave[i][y] == '.') {
					dropcount++;
				} else if (visit[C * i + y] && cave[i][y] == 'x') {
					dropcount = 0;
					break;
				} else {
					break;
				}
			}	  
			if (dropcount > 0 && min > dropcount) {
//				System.out.println(x + " " + y);
//				System.out.println(dropcount);
				min = dropcount;
			}
		}
		
		if(min>=R) {
			return;
		}
		while (!ice.isEmpty()) {
			int temp = ice.poll();
			dropice.add(temp);
			int x = temp / C;
			int y = temp % C;
			cave[x][y] = '.';
		}
		while (!dropice.isEmpty()) {
			int temp = dropice.poll();
			int x = temp / C;
			int y = temp % C;
			cave[x + min][y] = 'x';
		}
	}

	private static void searchCluster() {
		visit = new boolean[R * C + 1];
		ice.clear();
		dropice.clear();
		boolean flag = false;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (cave[i][j] == 'x' && !visit[i * C + j]) {
					dropice.clear();
					visit[i * C + j] = true;
					ice.add(i * C + j);
					dropice.add(i * C + j);
					while (!ice.isEmpty()) {
						int temp = ice.poll();
						int x = temp / C;
						int y = temp % C;
						for (int d = 0; d < 4; d++) {
							int ni = x + di[d];
							int nj = y + dj[d];
							if (ni >= 0 && nj >= 0 && ni < R && nj < C && cave[ni][nj] == 'x' && !visit[ni * C + nj]) {
								if (ni == R - 1) {
									flag = true;
								}
								visit[ni * C + nj] = true;
								ice.add(ni * C + nj);
								dropice.add(ni * C + nj);
							}
						}
					}
					if (!flag && !dropice.isEmpty()) {
						dropCluster();
						return;
					}
					flag = false;
				}
			}
		}
	}

	private static void throwSpear(int a) {
		int floor = R - spear[a];
		if (a % 2 == 0) {
			for (int i = 0; i < C; i++) {
				if (cave[floor][i] == 'x') {
					cave[floor][i] = '.';
					return;
				}
			}
		} else {
			for (int i = C - 1; i >= 0; i--) {
				if (cave[floor][i] == 'x') {
					cave[floor][i] = '.';
					return;
				}
			}
		}
	}
}
