package y2020.m07.d09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
풀이시간 : 51분
시간 : 84ms
메모리 : 12880KB
*/

public class Main_BJ_11559_PuyoPuyo_남동해 {
	public static int N = 12, M = 6, di[] = { -1, 0, 1, 0 }, dj[] = { 0, 1, 0, -1 }, colorCount, max, result;
	public static char field[][];
	public static boolean visit[][];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_11559.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		field = new char[N][M];
		result = 0;
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				field[i][j] = temp.charAt(j);
			}
		}
		boolean flag = false;			//연쇄작용 체크용
		boolean esc = false;			//while문 탈출용
		while (!esc) {
			esc=true;					//연쇄가 안 일어나면 탈출
			visit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (field[i][j] != '.') {	//블럭을 만나면
						visit[i][j] = true;		//방문처리
						colorCount = 1;			//블럭개수
						Puyo(i, j, field[i][j], false);		//블럭 dfs(i좌표, j좌표, 블럭색, 블럭파괴여부)
						if (colorCount >= 4) {				//이어진 블럭이 4개 이상이면
							if(!flag) {						//연쇄작용이 없었으면
								result++;					//횟수++
							}
							flag=true;						//연쇄작용 표시
							esc=false;						//연쇄가 일어났으므로 while문 탈출 안함
							visit = new boolean[N][M];
							Puyo(i, j, field[i][j], true);	//같은색 블럭 제거하며 dfs
						}
					}
				}
			}
			flag=false;		//연쇄작용 초기화

			Queue<Character> q = new LinkedList<>();	//Queue 이용하여 블럭 내리기
			for (int j = 0; j < M; j++) {
				for (int i = N - 1; i >= 0; i--) {
					if (field[i][j] != '.') {
						q.add(field[i][j]);
						field[i][j] = '.';
					}
				}

				for (int i = N - 1; i >= 0; i--) {
					if (!q.isEmpty()) {
						char temp = q.poll();
						field[i][j] = temp;
					} else {
						break;
					}
				}
			}
		}
		System.out.println(result);
	}

	private static void Puyo(int i, int j, char color, boolean check) {
		if (check) {			//check가 true이면 블럭 삭제
			field[i][j] = '.';
		}
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni >= 0 && nj >= 0 && ni < N && nj < M && !visit[ni][nj] && field[ni][nj] == color) {
				colorCount++;
				visit[ni][nj] = true;
				Puyo(ni, nj, color, check);
			}
		}
	}
}
