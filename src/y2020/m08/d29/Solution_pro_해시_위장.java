package y2020.m08.d29;

import java.util.HashMap;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_해시_위장 {
	public static void main(String[] args) throws Exception {
		String[][] clothes = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}};	//false
		
		System.out.println(solution(clothes));
	}
	
    public static int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++) {
        	String kind = clothes[i][1];
        	if(map.get(kind)==null) {
        		map.put(kind, 1);
        	}else {
        		map.put(kind, map.get(kind)+1);
        	}
        }
        answer = map.size();
        int a = 1;
        if(answer==1) {
        	for(String i : map.keySet()) {
        		answer = map.get(i);
        	}
        }else {
        	for(String i : map.keySet()) {
        		a*=map.get(i)+1;
        	}
        	answer=a-1;
        }
        return answer;
    }
}
