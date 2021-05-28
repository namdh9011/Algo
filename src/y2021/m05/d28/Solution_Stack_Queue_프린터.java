package y2021.m05.d28;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_Stack_Queue_프린터 {
	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		System.out.println(solution(priorities,location));
	}
	public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        int n = priorities.length;
        for(int i=0;i<n;i++){
            q.add(new int[] {i,priorities[i]});
        }
        Arrays.sort(priorities);
        int index = n-1;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int tar = priorities[index];
            if(curr[1]==tar){
                if(curr[0]==location){
                    return n-index;
                }
                index--;
            }else{
                q.add(curr);
            }
        }
        return answer;
    }
}

