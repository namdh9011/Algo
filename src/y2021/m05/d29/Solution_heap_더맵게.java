package y2021.m05.d29;

import java.util.PriorityQueue;

public class Solution_heap_더맵게 {
	public static void main(String[] args) {
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = scoville.length;
        for(int i=0;i<n;i++){
            pq.add(scoville[i]);
        }
        while(pq.size()>1){
            int cur1 = pq.poll();
            int cur2 = pq.poll();
            if(cur1>=K){
                return answer;
            }
            int mix = cur1 + (cur2*2);
            pq.add(mix);
            answer++;
        }
        if(pq.poll()>=K){
            return answer;
        }
        return -1;
    }
}

