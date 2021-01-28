package y2020.m10.d23;

import java.util.*;
/*
풀이시간 : 
시간 : 
메모리 : 
- 
*/
public class Main_prac_2_HashMap연습 {
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
		HashMap<Integer, ArrayList<Integer>> map1 = new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> map2 = new HashMap<>();
		for(int i=0;i<s1.length;i++) {
			if(map1.get(s1[i])==null) {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(i);
				map1.put(s1[i], al);
			}else {
				ArrayList<Integer> temp = map1.get(s1[i]);
				temp.add(i);
				map1.put(s1[i], temp);
			}
			if(map2.get(s2[i])==null) {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(i);
				map2.put(s2[i], al);
			}else {
				ArrayList<Integer> temp = map2.get(s2[i]);
				temp.add(i);
				map2.put(s2[i], temp);
			}
		}
		answer[1]=Integer.MAX_VALUE;
		Set<Integer> keys1 = map1.keySet();
		for(Integer key : keys1) {
			int count = 0;
			ArrayList<Integer> curr1 = map1.get(key);
			ArrayList<Integer> curr2 = map2.get(key);
			if(curr1==null||curr2==null||curr1.size()!=curr2.size()) {
				continue;
			}
			for(int i=0;i<curr1.size();i++) {
				count+=Math.abs(curr1.get(i)-curr2.get(i));
			}
			if(count<answer[1]) {
				answer[1]=count;
				answer[0]=key;
			}
		}
		return answer;
	}
}