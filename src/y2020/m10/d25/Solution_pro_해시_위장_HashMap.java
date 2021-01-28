package y2020.m10.d25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_해시_위장_HashMap {
	public static void main(String[] args) throws Exception {
		String[][] clothes = {{"yellow_hat","headgear"},{"blue_sunglasses","eyewear"},{"green_turban","headgear"}};	//false
		
		System.out.println(solution(clothes));
	}
	
	public static int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            if(map.get(clothes[i][1])==null){
                ArrayList<String> temp = new ArrayList<>();
                temp.add(clothes[i][0]);
                map.put(clothes[i][1],temp);   
            }else{
                ArrayList<String> temp = map.get(clothes[i][1]);
                temp.add(clothes[i][0]);
                map.put(clothes[i][1],temp);   
            }
        }
        Set<String> keys = map.keySet();
        int a = 1;   
        
        for(String key : keys){
            ArrayList<String> temp = map.get(key);
            a*=temp.size()+1;
        }
        answer = a-1;
        return answer;
    }
}
