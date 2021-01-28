package y2020.m08.d31;

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

public class Solution_pro_스택큐_프린터 {
	public static void main(String[] args) throws Exception {
//		int priorities[] = { 2, 1, 3, 2 };
//		int location = 2;
		
		int priorities[] = {1,1,9,1,1,1};
		int location = 0;

		System.out.println(solution(priorities, location));
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		for (int i = 0; i < priorities.length; i++) {
			q.add(new int[] { i, priorities[i] });
		}
		Arrays.sort(priorities);
		int len = priorities.length-1;
		while (!q.isEmpty()) {
			int curr[] = q.poll();
			if(priorities[len]>curr[1]) {	//우선순위가 높은게 있으면
				q.add(new int[] { curr[0], curr[1] });
			}else { // 우선순위가 높은게 없으면
				answer++;
				if (curr[0] == location) {
					break;
				}
				len--;
			}
		}
		return answer;
	}
}
