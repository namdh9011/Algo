package y2020.m09.d26;

import java.util.*;
public class Solution_pro_이분탐색_징검다리_보고품 {

	public static void main(String[] args) {
		int distance = 25;
		int[] rockes = {2,14,11,21,17};
		int n = 2;
		System.out.println(solution(distance,rockes, n));

	}
	public static long solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0;
        int right = 0;
        int mid = 0;
        right = distance/(rocks.length-n+1)+1;
        System.out.println(right);
        Arrays.sort(rocks);
        System.out.println(Arrays.toString(rocks));
        while(left<=right){
            int curr=0;
            int count = n;
            boolean f = false;
            boolean visit[] = new boolean[rocks.length];
            mid = (left+right)/2;
            for(int i=0;i<rocks.length;i++){
                if(rocks[i]-curr<mid){
                    count--;
                    if(count<0){
                        //조건
                        f=true;
                        break;
                    }
                }else{
                	visit[i]=true;
                    curr = rocks[i];
                }
            }
            //마지막돌
            if(count==0){
                if(distance-curr<mid){
                    f=true;
                }
            }else if(count>0){
                for(int i=rocks.length-1;i>=0;i--) {
                	if(!visit[i]) {
                		count--;
                		if(count==0) {
                			if(distance-rocks[i]<mid) {
                				f=true;
                			}
                			break;
                		}
                	}
                }
            }
            if(f){
                right = mid-1;
            }else{
            	if(answer<mid) {
            		answer=mid;
            	}
                left = mid+1;
            }
        }
        return answer;
    }
}
