package y2021.m05.d28;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Stack_Queue_다리를지나는트럭 {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		System.out.println(solution(bridge_length,weight,truck_weights));
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        Queue<int[]> q = new LinkedList<>();    //탈출시간, 무게
        int curr_weight = truck_weights[0];
        q.add(new int[] {bridge_length+time,truck_weights[0]});
        for(int i=1;i<truck_weights.length;i++){
            if(curr_weight+truck_weights[i]<=weight){
                time++;
            }
            while(curr_weight+truck_weights[i]>weight){
                int[] esc = q.poll();
                time=esc[0];
                curr_weight-=esc[1];
            }
            while(!q.isEmpty()&&q.peek()[0]<=time){
                curr_weight-=q.poll()[1];
            }
            curr_weight+=truck_weights[i];
            q.add(new int[] {time+bridge_length,truck_weights[i]});
        }
        while(!q.isEmpty()){
            int[] esc = q.poll();
            time=esc[0];
        }
        return time;
    }
}

