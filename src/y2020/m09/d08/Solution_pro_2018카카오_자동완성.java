package y2020.m09.d08;

import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_2018카카오_자동완성 {
	public static void main(String[] args) throws Exception {
//		String[] words = {"go", "gone", "guild"};
//		String[] words = {"abc", "def", "ghi","jklm"};
		String[] words = {"word", "war", "warrior","world"};
		System.out.println(solution(words));
	}
	
	public static int solution(String[] words) {
//		System.out.println("go".compareTo("g"));
		
//		String s = "gone";
//		if(s.compareTo("go")>=0&&s.compareTo("gp")<0) {
//			System.out.println("ok");
//		}
		
        int answer = 0;
        Arrays.sort(words);
        int N = words.length;
        int count = 0;
        for(int i=0;i<N;i++) {
        	String curr = words[i];
        	boolean flag = false;
    		for(int k=1;k<curr.length();k++) {
    			String sub = curr.substring(0,k);
//    			System.out.println("sub  " + sub);
    			
    			if(i-1>=0&&i+1<N) {
    				if(!words[i-1].contains(sub)&&!words[i+1].contains(sub)) {
    					count=k;
    					flag=true;
    					break;
    				}
    			}else if(i-1>=0&&i+1>=N) {
    				if(!words[i-1].contains(sub)) {
    					count=k;
    					flag=true;
    					break;
    				}
    			}else if(i-1<0&&i+1<N) {
    				if(!words[i+1].contains(sub)) {
    					count=k;
    					flag=true;
    					break;
    				}
    			}
    		}
    		if(flag) {
    			answer+=count;
    		}else{
    			answer+=curr.length();
    		}
        }
        return answer;
    }
}
