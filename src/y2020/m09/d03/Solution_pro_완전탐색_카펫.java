package y2020.m09.d03;

import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_완전탐색_카펫 {
	public static void main(String[] args) throws Exception {
		int brown = 24;
		int yellow = 24;
		System.out.println(Arrays.toString(solution(brown,yellow)));
	}

	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int N = brown + yellow;
        int garo = 0;
        int sero = 0;
        for(int i=2;i<N;i++) {
        	if(N%i==0) {
        		garo = i;
        		sero = N/i;
        		if(garo>=sero) {
        			if((garo-2)*(sero-2)==yellow) {
        				break;
        			}
        		}
        	}
        }
        answer[0]=garo;
        answer[1]=sero;
        return answer;
    }
}
