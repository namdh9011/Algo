package y2021.m02.d07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_pro_크레인인형뽑기 {
	public static void main(String[] args) throws Exception {
		int board[][] = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int moves[] = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board, moves));
	}
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Queue<Integer>[] q = new Queue[board.length];
        for(int i=0;i<board.length;i++) {
        	q[i] = new LinkedList<Integer>();
        	for(int j=0;j<board.length;j++) {
        		if(board[j][i]!=0) {
        			q[i].add(board[j][i]);
        		}
        	}
        }
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<moves.length;i++) {
        	if(q[moves[i]-1].size()<=0) {
        		continue;
        	}
        	int curr = q[moves[i]-1].poll();
        	if(stack.size()<=0) {
        		stack.add(curr);
        		continue;
        	}
        	int s = stack.peek();
        	if(curr==s) {
        		answer+=2;
        		stack.pop();
        	}else {
        		stack.add(curr);
        	}
        }
        return answer;
    }
}
