package y2021.m05.d27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4_nav {
	public static void main(String[] args) {
		int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
		int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
		System.out.println(solution(game_board, table));
	}
	public static class Block{
		int num;
		int[] bi;
		int[] bj;
		public Block() {}
		public Block(int num, int[] bi, int[] bj) {
			this.num = num;
			this.bi = bi;
			this.bj = bj;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public int[] getBi() {
			return bi;
		}
		public void setBi(int[] bi) {
			this.bi = bi;
		}
		public int[] getBj() {
			return bj;
		}
		public void setBj(int[] bj) {
			this.bj = bj;
		}
		@Override
		public String toString() {
			return "Block [num=" + num + ", bi=" + Arrays.toString(bi) + ", bj=" + Arrays.toString(bj) + "]";
		}
		
	}
	public static ArrayList<Block> al;
	public static int max;
    public static int solution(int[][] game_board, int[][] table) {
    	al=new ArrayList<>();
    	max = 0;
    	blockSelect(table);
    	System.out.println(al);
    	boolean[][] visit = new boolean[game_board.length][game_board.length];
		for(int j=0;j<4;j++) {
			insertBlock(game_board,0,j,visit,0);
		}
    	return max;
    }
	private static void insertBlock(int[][] game_board, int num,int command,boolean[][] visit, int count) {
		
		int n = game_board.length;
		boolean[][] temp = new boolean[n][n];
		for(int i=0;i<n;i++) {
			temp[i]=visit[i].clone();
		}
		Block b = al.get(num);
		int[] ti = b.bi;
		int[] tj = b.bj;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(game_board[i][j]==0) {
					if(command==0) {
						int cnt = 0;
						for(int d=0;d<ti.length;d++) {
							int ni = i + ti[d];
							int nj = j + tj[d];
							if(ni>=0&&nj>=0&&ni<n&&nj<n&&game_board[ni][nj]==0&&!visit[ni][nj]) {
								cnt++;
							}
						}
						if(cnt==ti.length) {
							for(int d=0;d<ti.length;d++) {
								int ni = i + ti[d];
								int nj = j + tj[d];
								if(ni>=0&&nj>=0&&ni<n&&nj<n&&game_board[ni][nj]==0&&!visit[ni][nj]) {
									visit[ni][nj]=true;
								}
							}
						}
					}else if(command==1) {
						
					}else if(command==2) {
						
					}else if(command==3) {
						
					}
				}
			}
		}
		for(int i=0;i<n;i++) {
			visit[i]=temp[i].clone();
		}
	}
	private static void blockSelect(int[][] table) {
		int n = table.length;
		int num = 1;
		boolean[][] visit = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(table[i][j]==1&&!visit[i][j]) {
					bfs(table,n,i,j,visit,num);
					num++;
				}
			}
		}
	}
	private static void bfs(int[][] table,int n, int i, int j, boolean[][] visit, int num) {
		int[] di = {-1,0,1,0};
		int[] dj = {0,1,0,-1};
		Block b = new Block();
		b.setNum(num);
		ArrayList<Integer> bi = new ArrayList<>();
		ArrayList<Integer> bj = new ArrayList<>();
		bi.add(i);
		bj.add(j);
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		visit[i][j]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<4;d++) {
				int ni = curr[0]+di[d];
				int nj = curr[1]+dj[d];
				if(ni>=0&&nj>=0&&ni<n&&nj<n&&table[ni][nj]==1&&!visit[ni][nj]) {
					visit[ni][nj]=true;
					q.add(new int[] {ni,nj});
					bi.add(ni);
					bj.add(nj);
				}
			}
		}
		int[] ti = new int[bi.size()];
		int[] tj = new int[bj.size()];
		for(int k=0;k<bi.size();k++) {
			ti[k]=bi.get(k)-bi.get(0);
			tj[k]=bj.get(k)-bj.get(0);
		}
		b.setBi(ti);
		b.setBj(tj);
		al.add(b);
	}
}