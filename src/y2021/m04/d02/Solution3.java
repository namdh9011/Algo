package y2021.m04.d02;

import java.util.Arrays;
//git 설정 변경
public class Solution3 {

	public static void main(String[] args) {
		System.out.println(solution(5,new int[] {2,3,9,4,5}));
//		System.out.println(solution(2,new int[] {1,3}));
//		System.out.println(solution(7,new int[] {9,6,5,4,3,5,4}));
//		System.out.println(solution(7,new int[] {1,2,5,4,8,6,7}));
	}
	public static int solution(int N, int[] array) {
        int answer = 1;
        int[] dp = new int[N];
        int[] dd = new int[N];
        dp[0]=1;
        dd[N-1]=1;
        for(int i=1;i<N;i++) {
        	if(array[i]>array[i-1]) {
        		dp[i]=dp[i-1]+1;
        	}else {
        		dp[i]=1;
        	}
        	answer = Math.max(answer, dp[i]);
        }
        
        for(int i=N-2;i>=0;i--) {
        	if(array[i]<array[i+1]) {
        		dd[i]=dd[i+1]+1;
        	}else {
        		dd[i]=1;
        	}
        	answer = Math.max(answer, dd[i]);
        }
        
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(dd));
        
        for(int i=1;i<N-1;i++) {
        	if(array[i-1]<array[i+1]) {
        		answer=Math.max(answer, dp[i-1]+dd[i+1]);
        	}
        }
        return answer;
    }
}
