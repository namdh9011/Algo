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

public class Solution_pro_2018카카오_자동완성_시간초과 {
	public static void main(String[] args) throws Exception {
		String[] words = {"go", "gone", "guild"};
//		String[] words = {"abc", "def", "ghi","jklm"};
//		String[] words = {"word", "war", "warrior","world"};
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
        for(int i=0;i<N;i++) {
        	String curr = words[i];
        	boolean flag=false;
        	int co = 0;
    		for(int k=1;k<curr.length();k++) {
    			String sub = curr.substring(0,k);
    			String next = curr.substring(0,k-1)+(char)(curr.charAt(k-1)+1);
//    			System.out.println("sub "+sub);
//    			System.out.println("next "+next);
    			
    			int count=0;
    			for(int j=0;j<N;j++) {
    				if(words[j].charAt(0)!=curr.charAt(0)) {
    					continue;
    				}
    				if(words[j].compareTo(sub)>=0&&words[j].compareTo(next)<0) {
//    					System.out.println("word " + words[j]);
    					count++;
    				}
    				if(count>1) {
    					break;
    				}
    			}
//    			System.out.println(count);
    			if(count==1) {
    				flag=true;
    				co=k;
    				break;
    			}
//    			System.out.println();
    		}
    		if(flag) {
    			answer+=co;
//    			System.out.println("횟수" + co);
    		}else {
    			answer+=words[i].length();
//    			System.out.println("횟수" + words[i].length());
    		}
        }
        return answer;
    }
}
