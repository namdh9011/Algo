package y2020.m09.d05;

import java.util.HashMap;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/
public class Solution_pro_2018카카오_뉴스클러스터링 {
	public static void main(String[] args) throws Exception {
//		String str1 = "FRANCE";
//		String str2 = "french";
//		String str1 = "handshake";
//		String str2 = "shake hands";
//		String str1 = "aa1+aa2";
//		String str2 = "AAAA12";
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		System.out.println(solution(str1,str2));
	}
	
	public static int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        HashMap<String, Integer> temp1 = new HashMap<>();
        HashMap<String, Integer> temp2 = new HashMap<>();
        int kyo = 0;
        int hap = 0;
        for(int i=0;i<str1.length()-1;i++) {
        	String tstring=str1.substring(i,i+2);
        	if(str1.charAt(i)<'A'||str1.charAt(i)>'Z'||str1.charAt(i+1)<'A'||str1.charAt(i+1)>'Z') {
        		continue;
        	}
        	if(temp1.get(tstring)==null) {
        		temp1.put(tstring, 1);
        	}else {
        		temp1.put(tstring, temp1.get(tstring)+1);
        	}
        }
        for(int i=0;i<str2.length()-1;i++) {
        	String tstring=str2.substring(i,i+2);
        	if(str2.charAt(i)<'A'||str2.charAt(i)>'Z'||str2.charAt(i+1)<'A'||str2.charAt(i+1)>'Z') {
        		continue;
        	}
        	if(temp2.get(tstring)==null) {
        		temp2.put(tstring, 1);
        	}else {
        		temp2.put(tstring, temp2.get(tstring)+1);
        	}
        }
        for(String t : temp1.keySet()) {
        	if(temp2.get(t)!=null) {
        		kyo+=Math.min(temp1.get(t), temp2.get(t));
        	}
        	if(temp2.get(t)==null) {
        		hap+=temp1.get(t);
        	}else {
        		hap+=Math.max(temp1.get(t), temp2.get(t));
        	}
        }
        for(String t :temp2.keySet()) {
        	if(temp1.get(t)==null) {
        		hap+=temp2.get(t);
        	}
        }
        if(kyo==0&&hap==0) {
        	answer=65536;
        }else {
        	double d = (double)kyo/hap;
        	answer=(int)(d*65536);
        }
        return answer;
    }
}
