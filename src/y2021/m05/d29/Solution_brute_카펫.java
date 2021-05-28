package y2021.m05.d29;

import java.util.Arrays;

public class Solution_brute_카펫 {
	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}
	public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        int by = brown+yellow;
        int ga = 0;
        int se = 0;
        for(int i=2;i<=Math.sqrt(by);i++){
            if(by%i==0){
                se = i;
                ga = by/i;
                if((ga-2)*(se-2)==yellow){
                    return new int[] {ga,se};
                }
            }
        }
        return answer;
    }
}

