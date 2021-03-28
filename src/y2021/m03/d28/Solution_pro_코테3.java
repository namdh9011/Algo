package y2021.m03.d28;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_pro_코테3 {
	public static void main(String[] args) throws Exception {
//		int N = 1;
//		int coffee_times[] = { 100, 1, 50, 1, 1 };
		int N = 3;
		int coffee_times[] = { 4, 2, 2, 5, 3 };
		System.out.println(Arrays.toString(Solution(N, coffee_times)));
	}

	private static int[] Solution(int N, int[] coffee_times) {
		int[] answer = new int[coffee_times.length];
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
		});
		for(int i=0;i<N;i++) {
			pq.add(new int[] {i+1,coffee_times[i]});
		}
		int index = 0;
		for(int i=N;i<coffee_times.length;i++) {
			int[] curr = pq.poll();
			answer[index]=curr[0];
			index++;
			pq.add(new int[] {i+1,coffee_times[i]+curr[1]});
		}
		while(!pq.isEmpty()) {
			answer[index]=pq.poll()[0];
			index++;
		}
		return answer;
	}
}
