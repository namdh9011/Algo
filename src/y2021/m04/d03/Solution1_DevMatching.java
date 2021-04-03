package y2021.m04.d03;

import java.util.Arrays;

public class Solution1_DevMatching {

	public static void main(String[] args) {
//		int[] lottos = {44, 1, 0, 0, 31, 25};
//		int[] win_nums = {31, 10, 45, 1, 6, 19};
//		int[] lottos = {0, 0, 0, 0, 0, 0};
//		int[] win_nums = {38, 19, 20, 40, 15, 25};
		int[] lottos = {45, 4, 35, 20, 3, 9};
		int[] win_nums = {20, 9, 3, 45, 4, 35};
		System.out.println(Arrays.toString(solution(lottos, win_nums)));
	}
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        boolean[] visit = new boolean[46];
        for(int i=0;i<win_nums.length;i++) {
        	visit[win_nums[i]]=true;
        }
        int tar = 0;
        int count=0;
        for(int i=0;i<lottos.length;i++) {
        	if(lottos[i]!=0) {
        		if(visit[lottos[i]]) {
        			tar++;
        		}
        	}else {
        		count++;
        	}
        }
        int[] rank = {6,6,5,4,3,2,1};
        answer[0]=rank[tar + count];
        answer[1]=rank[tar];
        return answer;
    }
}
