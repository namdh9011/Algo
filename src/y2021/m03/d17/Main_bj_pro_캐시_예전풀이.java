package y2021.m03.d17;

import java.util.LinkedList;
import java.util.Queue;

class Main_bj_pro_캐시_예전풀이 {
	public static void main(String[] args) throws Exception {
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
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