package y2021.m05.d31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution_sk2 {
	public static void main(String[] args) {
		int[] s1 = {4,8,8,2};
		int[] s2 = {2,8,8,4};
		System.out.println(Arrays.toString(solution(s1,s2)));
	}

	private static int[] solution(int[] s1, int[] s2) {
		int[] answer = new int[2];
		answer[0] = answer[1]=Integer.MAX_VALUE;
		HashMap<Integer, ArrayList<Integer>> map1 = new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> map2 = new HashMap<>();
		int n = s1.length;
		for(int i=0;i<n;i++) {
			int a = s1[i];
			int b = s2[i];
			if(map1.get(a)==null) {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(i);
				map1.put(a,al);
			}else {
				ArrayList<Integer> al = map1.get(a);
				al.add(i);
				map1.put(a,al);
			}
			if(map2.get(b)==null) {
				ArrayList<Integer> al = new ArrayList<>();
				al.add(i);
				map2.put(b,al);
			}else {
				ArrayList<Integer> al = map2.get(b);
				al.add(i);
				map2.put(b,al);
			}
		}
		for(Integer a:map1.keySet()) {
			int t = a;
			ArrayList<Integer> al1 = map1.get(t);
			ArrayList<Integer> al2 = map2.get(t);
			int sum = 0;
			for(int i=0;i<al1.size();i++) {
				sum+=Math.abs(al1.get(i)-al2.get(i));
			}
			if(sum==answer[1]) {
				answer[0]=Math.min(t,answer[0]);
			}else if(sum<answer[1]){
				answer[0]=t;
				answer[1]=sum;
			}
		}
		return answer;
	}
}
