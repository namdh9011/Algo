package y2020.m09.d12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_카카오코테_2 {
	public static void main(String[] args) throws Exception {
		String[] order = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		System.out.println(Arrays.toString(solution(order,course)));
	}
	
	public static int max;
	public static char a[];
	public static boolean visit[];
	public static HashMap<String, Integer> map;
	public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for(int i=0;i<orders.length;i++) {
        	String ss = orders[i];
        	char[] te = new char[ss.length()];
        	for(int j=0;j<ss.length();j++) {
        		te[j] = ss.charAt(j);
        	}
        	Arrays.sort(te);
        	ss="";
        	for(int j=0;j<te.length;j++) {
        		ss+=te[j];
        	}
        	orders[i]=ss;
        }
        
        ArrayList<String> al = new ArrayList<>();
        map = new HashMap<>();
        for(int i=0;i<course.length;i++) {
        	max = 0;
        	for(int j=0;j<orders.length;j++) {
        		a = new char[course[i]];
        		visit = new boolean[orders[j].length()];
        		comb(0,0,orders[j],course[i],orders[j].length());
        	}
        	for(String s : map.keySet()) {
        		if(map.get(s)==max) {
        			al.add(s);
        		}
        	}
        	map.clear();
        }
        Collections.sort(al);
        answer = new String[al.size()];
        for(int i=0;i<al.size();i++) {
        	answer[i]=al.get(i);
        }
        return answer;
    }

	private static void comb(int start, int count, String orders, int k, int l) {
		if(count==k) {
			String temp = "";
			for(int i=0;i<a.length;i++) {
				temp+=a[i];
			}
//			System.out.println(temp);
			if(map.get(temp)==null) {
				map.put(temp, 1);
			}else {
				map.put(temp, map.get(temp)+1);
				if(max<map.get(temp)) {
					max=map.get(temp);
				}
			}
			return;
		}
		
		for(int i=start;i<l;i++) {
			if(!visit[i]) {
				visit[i]=true;
				a[count]=orders.charAt(i);
				comb(i,count+1,orders,k,l);
				visit[i]=false;
			}
		}
	}
}
