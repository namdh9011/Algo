package y2020.m08.d28;

import java.util.Arrays;
import java.util.HashMap;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_해시_전화번호목록 {
	public static void main(String[] args) throws Exception {
//		String[] phone_book = { "119", "97674223", "1195524421" };	//false
//		String[] phone_book = { "123", "456", "789" };	//true
		String[] phone_book = { "12", "123", "1235", "567", "88" };	//false
		
		System.out.println(solution(phone_book));
	}

	
	public static boolean solution(String[] phone_book) {
		class Pho implements Comparable<Pho>{
			String num;
			int count;
			public Pho(String num, int count) {
				this.num = num;
				this.count = count;
			}
			@Override
			public int compareTo(Pho o) {
				return this.count-o.count;
			}
		}
		
        boolean answer = true;
        Pho[] p = new Pho[phone_book.length];
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<phone_book.length;i++) {
        	p[i]=new Pho(phone_book[i], phone_book[i].length());
        }
        Arrays.sort(p);
        for(int i=0;i<p.length;i++) {
        	String s = p[i].num;
        	for(int j=0;j<s.length();j++) {
        		if(map.get(s.substring(0,j+1))!=null) {
        			return false;
        		}
        	}
        	map.put(s, 1);
        }
        return answer;
    }
}
