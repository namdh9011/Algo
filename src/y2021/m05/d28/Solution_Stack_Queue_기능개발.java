package y2021.m05.d28;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_Stack_Queue_기능개발 {
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		System.out.println(Arrays.toString(solution(progresses,speeds)));
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] end = new int[n+1];
        for(int i=0;i<n;i++){
            double d = Math.ceil((double)(100-progresses[i])/speeds[i]);
            end[i]=(int)d;
        }
        end[n]=101;
        int curr = end[0];
        int count = 1;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(end[i]<=curr){
                count++;
            }else{
                al.add(count);
                curr=end[i];
                count=1;
            }
        }
        int[] answer = new int[al.size()];
        for(int i=0;i<al.size();i++){
            answer[i]=al.get(i);
        }
        return answer;
    }
}

