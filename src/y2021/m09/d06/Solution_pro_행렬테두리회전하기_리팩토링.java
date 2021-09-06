package y2021.m09.d06;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_pro_행렬테두리회전하기_리팩토링 {
	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int queries[][] = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}
	
	public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int index = 1;
        
        //init map
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j]=index++;
            }
        }
        
        //solve
        for(int i=0;i<queries.length;i++){
            answer[i] = solve(map, queries[i], rows, columns);
        }
        return answer;
    }
    
    public static int solve(int[][] map, int[] queries, int rows, int columns){
        int sx = queries[0]-1;
        int ex = queries[2]-1;
        int sy = queries[1]-1;
        int ey = queries[3]-1;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(map[sx][sy]);
        int min = Integer.MAX_VALUE;
        for(int i=sy;i<ey;i++){
            q.add(map[sx][i+1]);
            int temp = q.poll();
            if(temp<min) min = temp;
            map[sx][i+1]=temp;
        }
        for(int i=sx;i<ex;i++){
            q.add(map[i+1][ey]);
            int temp = q.poll();
            if(temp<min) min = temp;
            map[i+1][ey]=temp;
        }
        for(int i=ey;i>sy;i--){
            q.add(map[ex][i-1]);
            int temp = q.poll();
            if(temp<min) min = temp;
            map[ex][i-1]=temp;
        }
        for(int i=ex;i>sx;i--){
            q.add(map[i-1][sy]);
            int temp = q.poll();
            if(temp<min) min = temp;
            map[i-1][sy]=temp;
        }
        q.clear();
        return min;
    }
}
