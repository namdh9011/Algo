package y2021.m09.d11;

import java.util.Arrays;

public class Solution_pro_카카오6 {
	public static void main(String[] args) {
//		int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
//		int[][] skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		System.out.println(solution(board,skill));
	}
	
	public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = skill.length;
        for(int i=0;i<n;i++) {
    		solve(board, skill[i]);
        }
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length;j++) {
        		if(board[i][j]>0) {
        			answer++;
        		}
        	}
        }
        
        return answer;
    }

	private static void solve(int[][] board, int[] skill) {
		if(skill[0]==1) {
			for(int i=skill[1];i<=skill[3];i++) {
				for(int j=skill[2];j<=skill[4];j++) {
					board[i][j]-=skill[5];
				}
			}
		}else {
			for(int i=skill[1];i<=skill[3];i++) {
				for(int j=skill[2];j<=skill[4];j++) {
					board[i][j]+=skill[5];
				}
			}
		}
	}

}