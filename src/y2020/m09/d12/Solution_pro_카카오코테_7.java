package y2020.m09.d12;

import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_카카오코테_7 {
	public static void main(String[] args) throws Exception {
		int[][] v = {{1,4},{3,4},{3,10}};
		System.out.println(Arrays.toString(solution(v)));
	}
	
	public static int[] solution(int[][] v) {
        int[] answer = new int[2];
        if(v[0][0]==v[1][0]) {
        	answer[0] = v[2][0];
        }else {
        	if(v[0][0]==v[2][0]) {
        		answer[0] = v[1][0];
        	}else {
        		answer[0] = v[0][0];
        	}
        }
        if(v[0][1]==v[1][1]) {
        	answer[1] = v[2][1];
        }else {
        	if(v[0][1]==v[2][1]) {
        		answer[1] = v[1][1];
        	}else {
        		answer[1] = v[0][1];
        	}
        }
        
        return answer;
    }
}
