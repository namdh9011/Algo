package y2020.m09.d08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_2018카카오_압축 {
	public static void main(String[] args) throws Exception {
		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		System.out.println(Arrays.toString(solution(msg)));
	}
	
	public static int[] solution(String msg) {
        HashMap<String, Integer> dict = new HashMap<>();
        for(int i=0;i<'Z'-'A'+1;i++) {
        	int temp = 'A'+i;
        	String t = (char)temp+"";
        	dict.put(t, i+1);
        }
        ArrayList<Integer> al = new ArrayList<>();
        int N = msg.length();
        int count = 27;
        boolean[] visit = new boolean[N];
        for(int i=0;i<N;i++) {
        	int index = 0;
        	if(!visit[i]) {
	        	for(int j=i+1;j<N+1;j++) {
	        		if(dict.get(msg.substring(i,j))!=null) {
	        			index = dict.get(msg.substring(i,j));
	        			visit[j-1]=true;
	        		}else {
	        			dict.put(msg.substring(i,j), count);
	        			count++;
	        			break;
	        		}
	        	}
	        	al.add(index);
        	}
        }
        int[] answer = new int[al.size()];
        for(int i=0;i<answer.length;i++) {
        	answer[i]=al.get(i);
        }
        return answer;
    }
}
