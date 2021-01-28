package y2020.m12.d28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 */

class Main_bj_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	HashMap<Integer, String> num = new HashMap<>();
    	HashMap<String, Integer> name = new HashMap<>();
    	for(int i=1;i<=N;i++) {
    		String t = br.readLine();
    		num.put(i, t);
    		name.put(t, i);
    	}
    	for(int i=0;i<M;i++) {
    		String t = br.readLine();
    		if(name.get(t)==null) {
    			sb.append(num.get(Integer.parseInt(t))).append("\n");
    		}else {
    			sb.append(name.get(t)).append("\n");
    		}
    	}
    	System.out.println(sb.toString());
	}
}
