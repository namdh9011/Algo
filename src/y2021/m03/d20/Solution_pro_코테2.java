package y2021.m03.d20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/*
 */

public class Solution_pro_코테2 {
	public static void main(String[] args) throws Exception {
		String inp_str = "aaaaZZZZ)";
				
		System.out.println(Arrays.toString(solution(inp_str)));
	}
	public static int[] solution(String inp_str) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		if(inp_str.length()<8||inp_str.length()>15) {	//1
			pq.add(1);
		}
		int kindcount = 0;
		int lencount = 0;
		int len = inp_str.length();
		
		String s = inp_str.replaceAll("[0-9]*", "");
		if(s.length()!=len) {
			kindcount++;
			lencount+=len-s.length();
		}
		s = inp_str.replaceAll("[a-z]*", "");
		if(s.length()!=len) {
			kindcount++;
			lencount+=len-s.length();
		}
		s = inp_str.replaceAll("[A-Z]*", "");
		if(s.length()!=len) {
			kindcount++;
			lencount+=len-s.length();
		}
		s = inp_str.replaceAll("[~!@#$%^&*]*", "");
		if(s.length()!=len) {
			kindcount++;
			lencount+=(len-s.length());
		}
		if(lencount!=inp_str.length()) {
			pq.add(2);
		}
		if(kindcount<3) {
			pq.add(3);
		}
		char temp = inp_str.charAt(0);
		int cnt = 1;
		boolean f = false;
		for(int i=1;i<inp_str.length();i++) {
			if(inp_str.charAt(i)==temp) {
				cnt++;
			}else {
				if(cnt>=4) {
					pq.add(4);
					f=true;
					break;
				}
				cnt=1;
				temp=inp_str.charAt(i);
			}
		}
		if(!f&&cnt>=4) {
			pq.add(4);
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0;i<inp_str.length();i++) {
			char input = inp_str.charAt(i);
			if(map.containsKey(input)) {
				int t = map.get(input)+1;
				if(t>=5) {
					pq.add(5);
					break;
				}
				map.put(input,t);
			}else {
				map.put(input, 1);
			}
		}
		int[] answer = new int[pq.size()];
		for(int i=0;i<answer.length;i++) {
			answer[i]=pq.poll();
		}
		return answer;
	}
}
