package y2021.m02.d14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_3190_뱀_인규 {
	static int n;
	static int apple_cnt;
	static int[][] map;
	static int[][] apple_map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		apple_cnt = Integer.parseInt(br.readLine());
		apple_map = new int[n][n];
		map = new int[n][n];
		for (int i = 0; i < apple_cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int apple_x = Integer.parseInt(st.nextToken()) - 1;
			int apple_y = Integer.parseInt(st.nextToken()) - 1;
			apple_map[apple_x][apple_y] = 1;
		} // 사과 입력

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = -1;
			}
		} // map init

		int current_time = 0;
		int len = 1; // 몸길이
		int init_x = 0;
		int init_y = 0;
		int dir = 0;
		String ndir = "";
		int time = 0;
		map[init_x][init_y] = 0; // 처음 뱀이 위치한 곳
		int direction_cnt = Integer.parseInt(br.readLine()); // direction
		for (int i = 0; i <= direction_cnt; i++) {
			time = 98765421; // time init
			ndir = "L"; // ndir init
			if (i < direction_cnt) { // 벽에 닿지도 않고 몸에 닿지도 않은 경우
				StringTokenizer st = new StringTokenizer(br.readLine());
				time = Integer.parseInt(st.nextToken());
				ndir = st.nextToken();
			}
			while (current_time < time) { // 입력으로 주어진 N시간 안에 뱀이 움직일 수 있다면
				current_time += 1; // 시간 증가하고
				init_x += dx[dir]; // x이동
				init_y += dy[dir]; // y이동

				if (init_x < 0 || init_x >= n || init_y < 0 || init_y >= n) {
					// 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
					System.out.println(current_time);
					return;
				}
				if (apple_map[init_x][init_y] == 1) {
					len += 1;
					apple_map[init_x][init_y] = 0;
				} // 사과를 먹은 경우

				if (map[init_x][init_y] != -1 && current_time - map[init_x][init_y] <= len) {
					System.out.println(current_time);
					return;
				}
				map[init_x][init_y] = current_time;
			}
			if (ndir.equals("D")) {
				// 오른쪽
				dir = (dir + 1) % 4;
			} else {
				// 왼쪽
				dir = (dir + 3) % 4;
			}
		}
	}
}