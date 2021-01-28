package y2020.m08.d31;

import java.util.LinkedList;
import java.util.Queue;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_스택큐_다리를지나는트럭 {
	public static void main(String[] args) throws Exception {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};	//8
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10};	//101
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};	//110
		
		System.out.println(solution(bridge_length, weight,truck_weights));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
        Queue<Integer> wait = new LinkedList<Integer>();
        Queue<Integer[]> on_bridge = new LinkedList<Integer[]>();
        for(int i=0;i<truck_weights.length;i++) {
        	wait.add(truck_weights[i]);
        }
        int bridge=0;
        while(!wait.isEmpty()) {
        	int truck=wait.peek();
        	int a = on_bridge.size();
        	for(int i=0;i<a;i++) {
        		Integer[] t = on_bridge.poll();
        		if(t[1]-1!=0) {
        			on_bridge.add(new Integer[] {t[0], t[1]-1});
        		}else {
        			bridge-=t[0];
        		}
        	}
        	if(bridge+truck<=weight) {
        		wait.poll();
        		on_bridge.add(new Integer[] {truck,bridge_length});
        		bridge+=truck;
        	}
        	answer++;
        }
        return answer+bridge_length;
    }
}

