package y2020.m10.d21;

import java.util.*;
/*
풀이시간 : 
시간 : 
메모리 : 
- 
*/
public class Main_prac_2_시간터질듯 {
	public static void main(String[] args) throws Exception{
//		int s1[] = {1,1,3,3,3,6};
//		int s2[] = {6,3,1,3,1,3};
//		int s1[] = {9,3,7,7,5,5,3,3};
//		int s2[] = {3,3,5,7,5,7,3,9};
//		int s1[] = {4,8,8,2};
//		int s2[] = {2,8,8,4};
		
		int s1[] = new int[500001];
		int s2[] = new int[500001];
		for(int i=0;i<=500000;i++) {
			s1[i]=i;
			s2[i]=500000-i;
		}
		
		System.out.println(Arrays.toString(solution(s1, s2)));
	}
	public static int[] solution(int[] s1, int[] s2) {
		int[] answer = new int[2];
		answer[1] = Integer.MAX_VALUE;
		int[] count = new int[500001];
		for(int i=0;i<count.length;i++) {
			count[i]=-1;
		}
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		
		for(int i=0;i<s1.length;i++) {
			int curr = s1[i];
			if(count[curr]==-1) {
				count[curr]=0;
				for(int j=0;j<s1.length;j++) {
					if(curr==s1[j]) {
						q1.add(j);
					}
					if(curr==s2[j]) {
						q2.add(j);
					}
				}
				if(q1.size()!=q2.size()) {
					break;
				}
				int res = 0;
				while(!q1.isEmpty()) {
					int a = q1.poll();
					int b = q2.poll();
					if(a>b) {
						res += a-b;
					}else {
						res += b-a;
					}
				}
				if(res<answer[1]) {
					answer[1]=res;
					answer[0]=curr;
				}else if(res==answer[1]) {
					if(answer[0]>curr) {
						answer[1]=res;
						answer[0]=curr;
					}
				}
			}
		}
		return answer;
	}
}