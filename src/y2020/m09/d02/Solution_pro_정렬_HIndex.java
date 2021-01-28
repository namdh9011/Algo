package y2020.m09.d02;

import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_정렬_HIndex {
	public static void main(String[] args) throws Exception {
//		int citations[] = {12,11,10,9,8,1};
//		int citations[] = {6,6,6,6,6,1};
//		int citations[] = {20,21,22,23};
		int citations[] = { 4, 4, 4 };

		System.out.println(solution(citations));
	}

	public static int solution(int[] citations) {
		int answer = 0;
		int N = citations.length;
		Arrays.sort(citations);
		
		for (int i = 0; i < N; i++) {
			if (citations[i] >= N - i) {
				answer = N - i;
				break;
			}
		}
		return answer;
	}
}
