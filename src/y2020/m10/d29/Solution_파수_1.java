package y2020.m10.d29;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_파수_1 {
	public static void main(String[] args) throws Exception {
		String s = "{abc{ab}aa}{ab}";
		int[] input = {0, 4, 10, 11};
		System.out.println(Arrays.toString(solution(s, input)));
	}
	
	public static int[] solution(String s, int[] input) {
        int[] answer = new int[input.length];
        boolean[] visit = new boolean[s.length()];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)=='{') {
        		stack.add(i);
        	}else if(s.charAt(i)=='}') {
        		int a = stack.pop();
        		if(!visit[a]) {
        			visit[a]=true;
        			visit[i]=true;
	        		map.put(i, a);
	        		map.put(a, i);
        		}
        	}
        }
        for(int i=0;i<input.length;i++) {
        	answer[i]=map.get(input[i]);
        }
        return answer;
    }
}
