package y2021.m05.d28;

import java.util.HashMap;

public class Solution_Hash_완주하지못한선수 {
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		System.out.println(solution(participant, completion));
	}
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        int n = completion.length;
        for(int i=0;i<n;i++){
            String peo = completion[i];
            if(map.get(peo)==null){
                map.put(peo,1);
            }else{
                map.put(peo,map.get(peo)+1);
            }
        }
        n = participant.length;
        for(int i=0;i<n;i++){
            String curr = participant[i];
            if(map.get(curr)==null||map.get(curr)==0){
                answer=curr;
                break;
            }else{
                map.put(curr,map.get(curr)-1);
            }
        }
        return answer;
    }
}

