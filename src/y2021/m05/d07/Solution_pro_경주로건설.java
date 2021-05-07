package y2021.m05.d07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_pro_경주로건설 {
	public static void main(String[] args) {
		int[][] board = {{0,0,0},{0,0,0},{0,0,0}};
		System.out.println(solution(board));
	}
	public static int min, di[] = {-1,0,1,0}, dj[] = {0,-1,0,1}, memo[][];
    public static int solution(int[][] board) {
        int n = board.length;
        memo = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        int answer = 0;
        bfs(n, board);
        answer = memo[n-1][n-1];
        return answer;
    }
    public static void bfs(int n, int[][] board){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,0,-1});
        memo[0][0]=0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int d=0;d<4;d++){
                int ni = curr[0] + di[d];
                int nj = curr[1] + dj[d];
                if(ni>=0&&nj>=0&&ni<n&&nj<n&&board[ni][nj]==0){
                    if(curr[3]==-1){
                        memo[ni][nj]=curr[2]+100;
                        q.add(new int[] {ni,nj,curr[2]+100,d});
                    }else if(d==curr[3]&&memo[ni][nj]>=curr[2]+100){
                        memo[ni][nj]=curr[2]+100;
                        q.add(new int[] {ni,nj,curr[2]+100,d});
                    }else if(d!=curr[3]&&memo[ni][nj]>=curr[2]+600){
                        memo[ni][nj]=curr[2]+600;
                        q.add(new int[] {ni,nj,curr[2]+600,d});
                    }
                }
            }
        }
    }
}
