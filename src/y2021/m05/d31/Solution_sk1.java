package y2021.m05.d31;

import java.util.Arrays;

public class Solution_sk1 {
	public static void main(String[] args) {
		int[] math_scores = {80,50,30,20,10};
		int[] english_scores = {24,39,47,63,75};
		System.out.println(solution(math_scores,english_scores));
	}

	private static int solution(int[] math_scores, int[] english_scores) {
		int answer = 0;
		int n = math_scores.length;
		int[] math_rank = new int[n];
		int[] eng_rank = new int[n];
		int[] temp_ma = math_scores.clone();
		int[] temp_en = english_scores.clone();
		Arrays.sort(temp_ma);
		Arrays.sort(temp_en);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(math_scores[i]==temp_ma[j]) {
					math_rank[i]=n-j;
				}
				if(english_scores[i]==temp_en[j]) {
					eng_rank[i]=n-j;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(math_rank[i]>math_rank[j]&&eng_rank[i]>eng_rank[j]) {
					answer++;
				}
				if(math_rank[i]<math_rank[j]&&eng_rank[i]<eng_rank[j]) {
					answer++;
				}
			}
		}
		return answer;
	}
}
