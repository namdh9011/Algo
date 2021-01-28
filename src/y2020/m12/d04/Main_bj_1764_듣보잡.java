package y2020.m12.d04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton
 */

class Main_bj_1764_듣보잡 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());

    	HashMap<String, Integer> map = new HashMap<>();
    	HashSet<String> set = new HashSet<>();
    	for(int i=0;i<N;i++) {
    		String s = br.readLine();
			map.put(s, 1);
    	}
    	for(int i=0;i<M;i++) {
    		String s = br.readLine();
    		if(map.get(s)!=null) {
    			set.add(s);
    		}
    	}
    	System.out.println(set.size());
    	ArrayList<String> arr = new ArrayList<>(set);
    	Collections.sort(arr);
    	for(int i=0;i<arr.size();i++) {
    		System.out.println(arr.get(i));
    	}
    }
}