package y2021.m04.d02;

import java.util.HashSet;

public class Solution1 {

	public static void main(String[] args) {
		System.out.println(solution("zxzxz"));
	}
	public static int solution(String s) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<s.length();i++) {
        	boolean[] visit = new boolean[26];
        	for(int j=i;j<s.length();j++) {
        		if(!visit[s.charAt(j)-'a']) {
        			visit[s.charAt(j)-'a']=true;
        			set.add(s.substring(i,j+1));
        		}else {
        			break;
        		}
        	}
        }
        return set.size();
    }
}
