package y2020.m07.d06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_3197_백조의호수_남동해_시간터짐 {
	public static int R, C, swan[], di[] = { -1, 0, 1, 0 }, dj[] = { 0, 1, 0, -1 }, day;
	public static char lake[][];
	public static boolean visit[][], flag;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_3197.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		lake = new char[R][C];
		swan = new int[2];
		flag = false;
		day = 0;
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				lake[i][j] = temp.charAt(j);
				if (lake[i][j] == 'L') {
					swan[0] = i;
					swan[1] = j;
				}
			}
		}
		while (true) {
			visit = new boolean[R][C];
			visit[swan[0]][swan[1]] = true;
			searchSwan(swan[0], swan[1]);
			if (flag) {
				System.out.println(day);
				break;
			}
			visit = new boolean[R][C];
			melt();
			day++;
		}
	}

	private static void searchSwan(int i, int j) {
		if (flag) {
			return;
		}
		for (int d = 0; d < di.length; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni >= 0 && ni < R && nj >= 0 && nj < C && !visit[ni][nj]) {
				visit[ni][nj] = true;
				if (lake[ni][nj] == '.') {
					searchSwan(ni, nj);
				} else if (lake[ni][nj] == 'L') {
					flag = true;
					return;
				}
			}
		}
	}

	private static void melt() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (lake[i][j] == 'X') {
					for (int d = 0; d < di.length; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if (ni >= 0 && ni < R && nj >= 0 && nj < C && lake[ni][nj] == '.' && !visit[ni][nj]) {
							visit[i][j] = true;
							lake[i][j] = '.';
							break;
						}
					}
				}
			}
		}
	}
}
