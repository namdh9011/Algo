package y2020.m08.d28;

import java.util.HashMap;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_해시_완주하지못한선수 {
	public static void main(String[] args) throws Exception {
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };
		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < participant.length; i++) {
			String data = participant[i];
			if (map.get(data) == null) {
				map.put(data, 1);
			} else {
				map.put(data, map.get(data) + 1);
			}
		}

		for (int i = 0; i < completion.length; i++) {
			String data = completion[i];
			if (map.get(data).equals(1)) {
				map.remove(data);
			} else {
				map.put(data, map.get(data) - 1);
			}
		}
		
		for(String key : map.keySet()){
		    answer = key;
		}
		return answer;
	}
}
