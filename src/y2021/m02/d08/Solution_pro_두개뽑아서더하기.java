package y2021.m02.d08;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution_pro_두개뽑아서더하기 {
	public static void main(String[] args) throws Exception {
		int numbers[] = {2,1,3,4,1};
		
		System.out.println(Arrays.toString(solution(numbers)));
	}
	public static int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<numbers.length;i++) {
        	for(int j=i+1;j<numbers.length;j++) {
        		set.add(numbers[i]+numbers[j]);
        	}
        }
        int[] answer = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        for(int i=0;i<set.size();i++) {
        	answer[i]=iter.next();
        }
        Arrays.sort(answer);
        return answer;
    }
}
