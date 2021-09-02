package y2021.m03.d20;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 */

public class Solution_pro_코테1 {
	public static void main(String[] args) throws Exception {
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"JAVA", "JAVASCRIPT"};
		int[] preference = {7, 5};
//		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
//		String[] languages = {"PYTHON", "C++", "SQL"};
//		int[] preference = {7, 5, 5};
				
		System.out.println(solution(table,languages,preference));
	}
	public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int[] score = new int[table.length];
        String[] lan = new String[table.length];
        for(int i=0;i<table.length;i++) {
        	String[] input = table[i].split(" ");
        	lan[i]=input[0];
        	for(int j=1;j<input.length;j++) {
        		for(int k=0;k<languages.length;k++) {
        			if(input[j].equals(languages[k])) {
        				score[i]+=preference[k]*(6-j);
        			}
        		}
        	}
        }
        int max = 0;
        for(int i=0;i<score.length;i++) {
        	if(score[i]>max) {
        		max=score[i];
        	}
        }
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int i=0;i<score.length;i++) {
        	if(max==score[i]) {
        		pq.add(lan[i]);
        	}
        }
        answer = pq.poll();
        return answer;
	}
}
