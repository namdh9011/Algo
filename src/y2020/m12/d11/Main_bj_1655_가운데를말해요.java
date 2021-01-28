package y2020.m12.d11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
7
1
5
2
10
-99
7
5
 */

class Main_bj_1655_가운데를말해요 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	PriorityQueue<Integer> front = new PriorityQueue<>(Collections.reverseOrder());
    	PriorityQueue<Integer> back = new PriorityQueue<>();
    	int N = Integer.parseInt(br.readLine());
    	int f = Integer.parseInt(br.readLine());
    	front.add(f);
    	sb.append(f).append("\n");
    	for(int i=0;i<N-1;i++) {
    		int next = Integer.parseInt(br.readLine());
    		if(front.size()>back.size()) {
    			int temp = front.poll();
    			if(temp>next) {
    				front.add(next);
    				back.add(temp);
    			}else {
    				front.add(temp);
    				back.add(next);
    			}
    		}else {
    			int temp = back.poll();
    			if(temp>next) {
    				front.add(next);
    				back.add(temp);
    			}else {
    				front.add(temp);
    				back.add(next);
    			}
    		}
    		sb.append(front.peek()).append("\n");
    	}
    	System.out.println(sb.toString());
    }
}
