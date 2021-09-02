package y2021.m03.d20;

import java.util.Arrays;
import java.util.HashMap;

/*
 */

public class Solution_pro_코테3 {
	public static void main(String[] args) throws Exception {
//		String program = "line";
//		String[] flag_rules = { "-s STRING", "-n NUMBER", "-e NULL" };
//		String[] commands = { "line -s 123 -n HI", "line fun" };
		String program = "line";
		String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
		String[] commands = {"line -n 100 -s hi -e", "lien -s Bye"};

		System.out.println(Arrays.toString(solution(program, flag_rules, commands)));
	}

	public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
		boolean[] answer = new boolean[commands.length];
		Arrays.fill(answer, true);
		HashMap<String, String> map = new HashMap<>(); // 맵에 <flag_name, flag_argument_type> 형식으로 입력
		for (int i = 0; i < flag_rules.length; i++) {	// flag를 맵에 입력 받아준다.
			String[] input = flag_rules[i].split(" ");
			map.put(input[0], input[1]);
		}
		
		here: for (int i = 0; i < commands.length; i++) {
			String[] input = commands[i].split(" ");
			if (!input[0].equals(program)) {		//program명이 다르면 false리턴
				answer[i] = false;
			} else {								//program명이 맞으면
				String com = null;
				String nextcom = null;
				for (int j = 1; j < input.length; j++) {
					if (j == input.length - 1 || input[j + 1].charAt(0) == '-') {	//commands의 마지막 변수이거나 다음에 새로운 flag_name이 나오면 com을 null처리해 줌
						nextcom = null;
					}
					if (map.get(input[j]) == null) {		//현재 input[j]가 flag_argument인데
						if (com == null) {					//처리해줄 flag_name이 없으면
							answer[i] = false;				//false 리턴
							continue here;
						}
					} else {								//현재 input[j]가 flag_name이면 com에 처리할 명령 입력
						com = map.get(input[j]);
						nextcom=com;
						answer[i] = command(j, input, com);
						if(!answer[i]) {
							break;
						}
					}
					com=nextcom;
				}
			}
		}
		return answer;
	}

	private static boolean command(int index, String[] input, String com) {
		if (com.equals("NULL")) {								//명령 NULL 처리
			if (index != input.length - 1 && input[index + 1].charAt(0) != '-') {
				return false;
			}
		} else if (com.equals("STRING")) {						//명령 STRING 처리
			if (index == input.length - 1 || !input[index + 1].matches("[a-zA-Z]*")) {
				return false;
			}
		} else if (com.equals("NUMBER")) {						//명령 NUMBER 처리
			if (index == input.length - 1 || !input[index + 1].matches("[0-9]*")) {
				return false;
			}
		}
		return true;
	}
}
