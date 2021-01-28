package y2020.m09.d10;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_2018카카오_무지의먹방라이브_시간초과 {
	public static void main(String[] args) throws Exception {
		int[] food_times = {5,6,7};
		long k = 5;
		System.out.println(solution(food_times,k));
	}
	
	public static int solution(int[] food_times, long k) {
        int answer = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<food_times.length;i++) {
        	pq.add(food_times[i]);
        }
//        System.out.println(pq);
        int foodsize = 0;
        while(!pq.isEmpty()) {
//        	System.out.println(pq);
        	int t = pq.peek();
        	long del = t*pq.size();
//        	System.out.println(del);
        	foodsize = pq.size();
        	pq.clear();
        	if(del<=k) {
        		k=k-del;
        		for(int i=0;i<food_times.length;i++) {
        			if(food_times[i]!=0) {
        				food_times[i]-=t;
        			}
        			if(food_times[i]!=0) {
        				pq.add(food_times[i]);
        			}
        		}
        	}else {
        		break;
        	}
        }
    	if(k==0) {
    		for(int i=0;i<food_times.length;i++) {
    			if(food_times[i]!=0) {
    				answer = i+1;
    				break;
    			}
    		}
    	}else {
    		k=k%foodsize;
    		for(int i=0;i<food_times.length;i++) {
    			if(food_times[i]!=0) {
					if(k==0) {
						answer = i+1;
						break;
					}
					k--;
    			}
    		}
    	}
        return answer;
    }
}
