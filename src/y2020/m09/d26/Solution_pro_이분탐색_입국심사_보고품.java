package y2020.m09.d26;

public class Solution_pro_이분탐색_입국심사_보고품 {

	public static void main(String[] args) {
		int n = 6;
		int[] times = {7,10};
		System.out.println(solution(n,times));

	}
	public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long min = 0;
        long mid = 0;
        long max = 0;
        for(int i=0;i<times.length;i++){
            if(times[i]>max){
                max = times[i];
            }
        }
        max = max*n;
        while(min<=max){
        	long count = 0;
        	mid = (max + min) / 2;
            for(int i=0;i<times.length;i++){
                count+=mid/times[i];
            }
            if(count<n){  
            	min = mid+1;
            }else{
            	if(answer>mid) {
            		answer = mid;
            	}
                max = mid-1;
            }
        }
        return answer;
    }
}
