package y2021.m02.d09;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_코테4_초기풀이 {
	public static void main(String[] args) throws Exception {
//		String[] board = {"..XXX..", "X....X.", "..X....", "X.C..X.", ".X.....", "....XX.", "..X.X.."};
//		int[][] choices = {{0, 0}, {0, 6}};
//		String[] board = {".XXXX", "X...X", ".X..X", ".X.CX", ".XXXX"};
//		int[][] choices = {{0, 0}, {2, 0}, {3, 0}, {4, 0}};
//		String[] board = {".....", ".XXX.", ".XC.X", ".XXX.", "....."};
//		int[][] choices = {{0, 0}, {0, 1}, {2, 3}, {0, 2}};
		String[] board = {".....", "...XX", "...X.", "..XC.", "..X.."};
		int[][] choices = {{2, 4}, {0, 0}, {0, 1}};
		
		System.out.println(Arrays.toString(solution(board, choices)));
	}
	public static int di[][] = {{-1,-1,0,0,1,1},{-1,-1,0,0,1,1}},dj[][] = {{-1,0,-1,1,-1,0},{0,1,-1,1,0,1}};
	public static int D[][],R[][],map[][],cat[],cnt;
	public static boolean glob[][],endgame;
	public static int[] solution(String[] board, int[][] choices) {
		int[] answer = new int[2];
		cat = new int[2];
		map = new int[board.length][board[0].length()];
		glob = new boolean[board.length][board[0].length()];
		D = new int[board.length][board[0].length()];
		R = new int[board.length][board[0].length()];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length();j++) {
				if(board[i].charAt(j)=='.') {
					map[i][j]=0;
				}else if(board[i].charAt(j)=='X') {
					map[i][j]=1;
				}else if(board[i].charAt(j)=='C') {
					cat[0]=i;
					cat[1]=j;
				}
			}
		}
		for(int i=0;i<choices.length;i++) {
			map[choices[i][0]][choices[i][1]]=1;
			calcDR();
			moveCat();
			if(endgame) {
				break;
			}
		}
		answer[0]=cat[0];
		answer[1]=cat[1];
        return answer;
    }
	private static void moveCat() {
		if(D[cat[0]][cat[1]]==0) {
			for(int d=0;d<6;d++) {
				int ni = cat[0] + di[cat[0]%2][d];
				int nj = cat[1] + dj[cat[0]%2][d];
				if(ni>=0&&nj>=0&&ni<map.length&&nj<map[0].length&&map[ni][nj]==0) {
					cat[0]=ni;
					cat[1]=nj;
					return;
				}
			}
			endgame=true;
		}else {
			PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					if(o1[0]==o2[0]) {
						if(o1[1]>o2[1]) {
							return -1;
						}else if(o1[1]<o2[1]) {
							return 1;
						}else {
							return (int)(o1[2]-o2[2]);
						}
					}
					return (int)(o1[0]-o2[0]);
				}
			});
			
			for(int d=0;d<6;d++) {
				int ni = cat[0] + di[cat[0]%2][d];
				int nj = cat[1] + dj[cat[0]%2][d];
				if(ni>=0&&nj>=0&&ni<map.length&&nj<map[0].length&&map[ni][nj]==0) {
					if(ni==0||nj==0||ni==map.length-1||nj==map[0].length-1) {
						endgame=true;
						cat[0]=ni;
						cat[1]=nj;
						return;
					}
					pq.add(new double[] {D[ni][nj],(double)R[ni][nj]/D[ni][nj],d});
				}
			}
			double[] temp = pq.poll();
			int dd = cat[0]%2;
			cat[0]=cat[0]+di[dd][(int)temp[2]];
			cat[1]=cat[1]+dj[dd][(int)temp[2]];
		}
	}
	
	private static void calcDR() {
		for(int i=1;i<map.length-1;i++) {
			for(int j=1;j<map[0].length-1;j++) {
				if(map[i][j]==0) {
					bfs(i,j);
					cnt=0;
					dfs(i,j,0,D[i][j]);
					R[i][j]=cnt;
				}
			}
		}
	}
	
	private static void dfs(int x, int y, int count, int K) {
		if(K==count) {
			if(x==0||y==0||x==map.length-1||y==map[0].length-1) {
				cnt++;
			}
			return;
		}
		for(int d=0;d<6;d++) {
			int ni = x + di[x%2][d];
			int nj = y + dj[x%2][d];
			if(ni>=0&&nj>=0&&ni<map.length&&nj<map[0].length&&map[ni][nj]==0&&!glob[ni][nj]) {
				glob[ni][nj]=true;
				dfs(ni,nj,count+1,K);
				glob[ni][nj]=false;
			}
		}
	}
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[map.length][map[0].length];
		visit[x][y]=true;
		q.add(new int[] {x,y,0});
		int esc = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<6;d++) {
				int ni = curr[0] + di[curr[0]%2][d];
				int nj = curr[1] + dj[curr[0]%2][d];
				if(ni>=0&&nj>=0&&ni<map.length&&nj<map[0].length&&map[ni][nj]==0&&!visit[ni][nj]&&curr[2]+1<=esc) {
					if(ni==0||nj==0||ni==map.length-1||nj==map[0].length-1) {
						esc=curr[2]+1;
					}
					visit[ni][nj]=true;
					q.add(new int[] {ni,nj,curr[2]+1});
				}
			}
		}
		if(esc!=Integer.MAX_VALUE) {
			D[x][y]=esc;
		}
	}
}
