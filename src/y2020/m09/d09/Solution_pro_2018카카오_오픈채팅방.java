package y2020.m09.d09;

import java.util.Arrays;
import java.util.HashMap;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_2018카카오_오픈채팅방 {
	public static void main(String[] args) throws Exception {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(record)));
	}
	
	public static String[] solution(String[] record) {
        int N = record.length;
        HashMap<String, String> map = new HashMap<>();
        int count=0;
        for(int i=0;i<N;i++) {
        	String curr[] = record[i].split(" ");
        	if(curr[0].equals("Enter")) {
        		map.put(curr[1], curr[2]);
        		count++;
        	}else if(curr[0].equals("Leave")) {
        		count++;
        	}else if(curr[0].equals("Change")) {
        		map.put(curr[1], curr[2]);
        	}
        }
        String[] answer = new String[count];
        count=0;
        for(int i=0;i<N;i++) {
        	String curr[] = record[i].split(" ");
        	if(curr[0].equals("Enter")) {
        		answer[count]=map.get(curr[1]) + "님이 들어왔습니다.";
        		count++;
        	}else if(curr[0].equals("Leave")) {
        		answer[count]=map.get(curr[1]) + "님이 나갔습니다.";
        		count++;
        	}else if(curr[0].equals("Change")) {
        		
        	}
        	
        }
        return answer;
    }
}
