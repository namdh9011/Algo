package y2020.m12.d28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
 */

class Main_bj_10816_숫자카드2 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	HashMap<Integer, Integer> map = new HashMap<>();
    	int N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		int num = Integer.parseInt(st.nextToken());
    		if(map.get(num)==null) {
    			map.put(num, 1);
    		}else {
    			map.put(num, map.get(num)+1);
    		}
    	}
    	int M = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<M;i++) {
    		int num = Integer.parseInt(st.nextToken());
    		if(map.get(num)==null) {
    			sb.append("0").append(" ");
    		}else {
    			sb.append(map.get(num)).append(" ");
    		}
    	}
    	System.out.println(sb.toString());
	}
}
