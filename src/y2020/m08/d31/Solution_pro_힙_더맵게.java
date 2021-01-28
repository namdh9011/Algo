package y2020.m08.d31;

import java.util.PriorityQueue;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_힙_더맵게 {
	public static void main(String[] args) throws Exception {
		int scovile[] = {12,9,3,2,10,1};
		int K = 7;

		System.out.println(solution(scovile, K));
	}

	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<scoville.length;i++) {
        	pq.offer(scoville[i]);
        }
        while(pq.size()>1) {
        	int a = pq.poll();
        	int b = pq.poll();
        	if(a>K) {
        		break;
        	}else {
        		answer++;
        		pq.offer(a+b*2);
        	}
        }
        if(pq.size()==1&&pq.peek()<K) {
        	answer=-1;
        }
        return answer;
    }
}
