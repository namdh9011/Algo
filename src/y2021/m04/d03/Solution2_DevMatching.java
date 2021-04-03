package y2021.m04.d03;

import java.util.Arrays;

public class Solution2_DevMatching {

	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}
	public static int map[][];
	public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        int t = 1;
        for(int i=0;i<rows;i++) {
        	for(int j=0;j<columns;j++) {
        		map[i][j]=t;
        		t++;
        	}
        }
        for(int i=0;i<queries.length;i++) {
        	answer[i]=spin(queries[i][0]-1,queries[i][1]-1,queries[i][2]-1,queries[i][3]-1);
        }
        return answer;
    }
	public static int spin(int x1, int y1, int x2, int y2) {
		int move[] = {y2-y1,x2-x1,y2-y1,x2-x1};
		int di[] = {0,1,0,-1};
		int dj[] = {1,0,-1,0};
		int curr = map[x1][y1];
		int dir = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<move.length;i++) {
			for(int j=0;j<move[i];j++) {
				x1 += di[dir];
				y1 += dj[dir];
				min=Math.min(min,curr);
				int temp = map[x1][y1];
				map[x1][y1]=curr;
				curr=temp;
			}
			dir++;
		}
		return min;
	}
}
