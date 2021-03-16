package y2021.m03.d17;

import java.util.LinkedList;
import java.util.Queue;

class Main_bj_pro_프렌즈4블록_예전풀이 {
	public static void main(String[] args) throws Exception {
		int m = 4;
		int n = 5;
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		System.out.println(solution(m,n,board));
	}
	public static boolean esc;
	public static int answer;
	public static int solution(int m, int n, String[] board) {
		answer = 0;
		char[][] map = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}

		esc=false;
		while(!esc) {
			esc=true;
			map = remove(m, n, map);
			map = dropDown(m,n,map);
		}

		return answer;
	}

	private static char[][] dropDown(int m, int n, char[][] map) {
		Queue<Character> q = new LinkedList<Character>();
		for(int j=0;j<n;j++) {
			for(int i=m-1;i>=0;i--) {
				if(map[i][j]!=' ') {
					q.add(map[i][j]);
					map[i][j]=' ';
				}
			}
			int t = q.size();
			for(int i=0;i<t;i++) {
				map[m-i-1][j]=q.poll();
			}
		}
		return map;
	}

	private static char[][] remove(int m, int n, char[][] map) {
		boolean[][] visit = new boolean[m][n];
		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				char temp = map[i][j];
				if(temp == ' ') {
					continue;
				}
				boolean flag = false;
				for (int k = 0; k < 2; k++) {
					for (int l = 0; l < 2; l++) {
						if (map[i + k][j + l] != temp) {
							flag = true;
						}
					}
				}
				if (!flag) {
					esc=false;
					for (int k = 0; k < 2; k++) {
						for (int l = 0; l < 2; l++) {
							visit[i + k][j + l] = true;
						}
					}
				}
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(visit[i][j]) {
					map[i][j] = ' ';
					answer++;
				}
			}
		}
		return map;
	}
}