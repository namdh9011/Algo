package y2021.m05.d28;

import java.util.Arrays;

public class Solution_Stack_Queue_주식가격 {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(solution(prices)));
	}
	public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            int curr = prices[i];
            for(int j=i+1;j<n;j++){
                answer[i]++;
                if(prices[j]<curr){
                    break;
                }
            }
        }
        return answer;
    }
}

