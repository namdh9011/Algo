package y2020.m08.d30;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_스택큐_기능개발 {
	public static void main(String[] args) throws Exception {
//		int[] progresses = {93,30,55};
//		int[] speeds = {1,30,5};			// return[2,1]
		int[] progresses = {95,90,99,99,80,99};
		int[] speeds = {1,1,1,1,1,1};			// return[1,3,2]
		
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for(int i=0;i<progresses.length;i++) {
        	double temp = (100-progresses[i])/speeds[i];
        	if((100-progresses[i])%speeds[i]==0){
        		days[i]=(int)temp;
        	}else {
        		days[i]=(int)temp+1;
        	}
        }
        int count=0;
        int first=days[0];
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=1;i<days.length;i++) {
        	count++;
        	if(days[i]>first) {
        		q.add(count);
        		first=days[i];
        		count=0;
        	}
        }
        q.add(count+1);
        
        int[] answer = new int[q.size()];
        int a=0;
        while(!q.isEmpty()) {
        	answer[a]=q.poll();
        	a++;
        }
        return answer;
    }
}
