package y2020.m09.d02;

import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_정렬_K번째수 {
	public static void main(String[] args) throws Exception {
		int array[] = {1,5,2,6,3,7,4};
		int commands[][] = {{2,5,3},{4,4,1},{1,7,3}};

		System.out.println(Arrays.toString(solution(array,commands)));
	}

	public static int[] solution(int[] array, int[][] commands) {
        int N = commands.length;
        int[] answer = new int[N];
        for(int i=0;i<N;i++) {
        	int len = commands[i][1]-commands[i][0]+1;
        	int narr[] = new int[len];
        	for(int j=0;j<len;j++) {
        		narr[j] = array[j+commands[i][0]-1];
        	}
        	Arrays.sort(narr);
        	answer[i] = narr[commands[i][2]-1];
        }
        return answer;
    }
}
