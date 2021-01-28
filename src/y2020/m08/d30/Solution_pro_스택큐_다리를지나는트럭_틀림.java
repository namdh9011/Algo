package y2020.m08.d30;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_스택큐_다리를지나는트럭_틀림 {
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
//		int bridge_length = 4;
//		int weight = 2;
//		int[] truck_weights = {1,1,1,1};
		
		System.out.println(solution(bridge_length, weight,truck_weights));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge = 0;
        for(int i=0;i<truck_weights.length;i++) {
        	if(bridge+truck_weights[i]>weight) {
        		answer+=bridge_length-1;
        		bridge=truck_weights[i];
        	}else {
        		bridge+=truck_weights[i];
        	}
        	answer++;
        }
        if(bridge!=0) {
        	answer+=bridge_length-1;
        }
        return answer;
    }
}
