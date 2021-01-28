package y2020.m09.d02;

import java.util.Arrays;
import java.util.Comparator;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_정렬_가장큰수_정답봄 {
	public static void main(String[] args) throws Exception {
//		int numbers[] = {6, 10, 2};
//		int numbers[] = {3, 30, 34, 5, 9};
//		int numbers[] = {3, 30, 31 ,330, 303,340, 3330, 34, 5, 9};
		int numbers[] = {0,0,0,0};

		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
        String answer = "";
        int N = numbers.length;
        String[] nnum = new String[N];
        for(int i=0;i<N;i++) {
        	nnum[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(nnum, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
        for(int i=0;i<nnum.length;i++) {
        	answer+=nnum[i];
        }
        if(answer.charAt(0)=='0') {
        	answer = "0";
        }
        return answer;
    }
}
