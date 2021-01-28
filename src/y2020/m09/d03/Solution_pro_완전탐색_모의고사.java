package y2020.m09.d03;

import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_완전탐색_모의고사 {
	public static void main(String[] args) throws Exception {
//		int array[] = {1,2,3,4,5};
		int array[] = {0,0,0,0,0};

		System.out.println(Arrays.toString(solution(array)));
	}

	public static int[] solution(int[] answers) {
        int[] stua = {1,2,3,4,5};
        int[] stub = {2,1,2,3,2,4,2,5};
        int[] stuc = {3,3,1,1,2,2,4,4,5,5};
        
        int[] count = new int[3];
        		
        for(int i=0;i<answers.length;i++) {
        	int sol = answers[i];
        	if(stua[i%5]==sol) {
        		count[0]++;
        	}
        	if(stub[i%8]==sol) {
        		count[1]++;
        	}
        	if(stuc[i%10]==sol) {
        		count[2]++;
        	}
        }
        
        int temp=0;
        for(int i=0;i<3;i++) {
        	if(count[i]>temp) {
        		temp=count[i];
        	}
        }
        int a[] = new int[3];
        int co=0;
        for(int i=0;i<3;i++) {
        	if(temp==count[i]) {
        		a[co]=i+1;
        		co++;
        	}
        }
        int[] answer = new int[co];
        for(int i=0;i<co;i++) {
        	answer[i]=a[i];
        }
        
        return answer;
    }
}
