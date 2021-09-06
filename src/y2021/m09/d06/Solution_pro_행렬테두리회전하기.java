package y2021.m09.d06;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution_pro_행렬테두리회전하기 {
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
        
        Deque<Integer> q = new LinkedList<>();
        for(int i=sy;i<ey;i++){
            q.add(map[sx][i]);
        }
        for(int i=sx;i<ex;i++){
            q.add(map[i][ey]);
        }
        for(int i=ey;i>sy;i--){
            q.add(map[ex][i]);
        }
        for(int i=ex;i>sx;i--){
            q.add(map[i][sy]);
        }
        
        q.addFirst(q.pollLast());
        
        int min = Integer.MAX_VALUE;
        for(int i=sy;i<ey;i++){
            int temp = q.poll();
            if(min>temp){
                min=temp;
            }
            map[sx][i]=temp;
        }
        for(int i=sx;i<ex;i++){
            int temp = q.poll();
            if(min>temp){
                min=temp;
            }
            map[i][ey]=temp;
        }
        for(int i=ey;i>sy;i--){
            int temp = q.poll();
            if(min>temp){
                min=temp;
            }
            map[ex][i]=temp;
        }
        for(int i=ex;i>sx;i--){
            int temp = q.poll();
            if(min>temp){
                min=temp;
            }
            map[i][sy]=temp;
        }
        return min;
    }
}
