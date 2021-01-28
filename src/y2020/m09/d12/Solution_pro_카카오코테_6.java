package y2020.m09.d12;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_카카오코테_6 {
	public static void main(String[] args) throws Exception {
		int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
		int r=1;
		int c=0;
		System.out.println(solution(board,r,c));
	}
	
	public static int di[]= {-1,0,1,0},dj[]= {0,1,0,-1},nboard[][],count,front;
	public static int solution(int[][] board, int r, int c) {
        int answer = 0;
        nboard = new int[4][4];
        boolean[][] visit = new boolean[4][4];
        count=0;
        front=-1;
        for(int i=0;i<4;i++) {
        	for(int j=0;j<4;j++) {
        		nboard[i][j]=board[i][j];
        		if(nboard[i][j]!=0) {
        			count++;
        		}
        	}
        }
        for(int i=0;i<board.length;i++) {
        	System.out.println(Arrays.toString(board[i]));
        }
//        move(r,c,dir,command);
        if(nboard[r][c]!=0) {
        	dfs(r,c,0,visit);
        	front=nboard[r][c];
        	nboard[r][c]=0;
        	visit[r][c]=true;
        	dfs(r,c,1,visit);
        }else {
        	dfs(r,c,0,visit);
        }
        return answer;
    }
	private static void dfs(int r, int c,int mo,boolean[][] visit) {
		if(count==0) {
			System.out.println(mo);
			return;
		}
//		System.out.println(r + " " + c);
		for(int i=0;i<2;i++) {
			for(int d=0;d<4;d++) {
				int[] curr = move(r,c,d,i);
				int ni = curr[0];
				int nj = curr[1];
				if(!(ni==r&&nj==c)) {
					if(ni>=0&&ni<4&&nj>=0&&nj<4) {
						if(nboard[ni][nj]!=0) {
							
						}else {
							
						}
					}
				}
			}
		}
	}
	private static int[] move(int r, int c, int dir, int com) {
		if(com==0) {
			int nr = r+di[dir];
			int nc = c+dj[dir];
			return new int[] {nr,nc};
		}else {
			for(int i=1;i<4;i++) {
				int nr = r+di[dir]*i;
				int nc = c+dj[dir]*i;
				if(nr>=0&&nr<4&&nc>=0&&nc<4&&nboard[nr][nc]!=0) {
					return new int[] {nr,nc};
				}
			}
			for(int i=3;i>0;i--) {
				int nr = r+di[dir]*i;
				int nc = c+dj[dir]*i;
				if(nr>=0&&nr<4&&nc>=0&&nc<4) {
					return new int[] {nr,nc};
				}
			}
			return new int[] {r,c};
		}
	}
}
