package y2020.m09.d05;

import java.util.LinkedList;
import java.util.Queue;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/
public class Solution_pro_2018카카오_캐시 {
	public static void main(String[] args) throws Exception {
		int cacheSize = 3;
		String[] cities = { "Jeju", "Pangyo", "Seoul", "Jeju","Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		System.out.println(solution(cacheSize, cities));
	}
	public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        int n = cities.length;
        for(int i=0;i<n;i++) {
        	cities[i]= cities[i].toUpperCase();
        }
        for(int i=0;i<n;i++) {
        	String t = cities[i];
        	boolean hit = false;
        	int s = q.size();
        	for(int j=0;j<s;j++) {
        		String temp = q.poll();
        		if(t.equals(temp)) {
        			hit=true;
        		}else {
        			q.add(temp);
        		}
        	}
        	if(hit) {
        		answer++;
        	}else {
        		answer+=5;
        	}
        	s=q.size();
        	if(cacheSize==0) {
        		continue;
        	}
        	if(s<cacheSize) {
        		q.add(t);
        	}else {
        		q.poll();
        		q.add(t);
        	}
        }
        return answer;
    }
}
