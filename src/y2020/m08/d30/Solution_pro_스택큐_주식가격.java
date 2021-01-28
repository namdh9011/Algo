package y2020.m08.d30;

import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_스택큐_주식가격 {
	public static void main(String[] args) throws Exception {
		int[] prices = {1,2,3,2,3};
		
		System.out.println(Arrays.toString(solution(prices)));
	}
	
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        here:for(int i=0;i<prices.length-1;i++) {
        	int t=0;
        	for(int j=i+1;j<prices.length;j++) {
        		t++;
        		if(prices[i]>prices[j]) {
        			answer[i]=t;
        			continue here;
        		}
        	}
        	answer[i]=t;
        }
        return answer;
    }
}
