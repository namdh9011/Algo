package y2020.m09.d25;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_엔테크_4번 {
	public static void main(String[] args) throws Exception{
		int t1[][] = {{1,2},{3,4},{5,6},{-1,7},{8,9},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
		int t2[][] = {{1,2},{-1,-1},{-1,-1}};
		System.out.println(solution(t1,t2));
	}

	public static int solution(int[][] t1, int[][] t2) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<t1.length;i++) {
        	q.add(0);
        	q.add(i);
        	while(!q.isEmpty()) {
        		boolean fa = false;
        		boolean fb = false;
        		
        		int t2curr = q.poll();
        		int t1curr = q.poll();
        		int t1a = t1[t1curr][0];
        		int t1b = t1[t1curr][1];
        		int t2a = t2[t2curr][0];
        		int t2b = t2[t2curr][1];
        		if(t1a!=-1&&t2a!=-1) {
        			q.add(t2a);
        			q.add(t1a);
        		}else if(t1a!=-1&&t2a==-1) {
        			q.clear();
        			break;
        		}else if(t1a==-1&&t2a!=-1) {
        			q.clear();
        			break;
        		}else {
        			fa = true;
        		}
        		
        		if(t1b!=-1&&t2b!=-1) {
        			q.add(t2b);
        			q.add(t1b);
        		}else if(t1b!=-1&&t2b==-1) {
        			q.clear();
        			break;
        		}else if(t1b==-1&&t2b!=-1) {
        			q.clear();
        			break;
        		}else {
        			fb = true;
        		}
        		
        		if(fa&&fb) {
        			answer++;
        			break;
        		}else if(fa&&!fb) {
        			
        		}else if(!fa&&fb) {
        			
        		}
        	}
        }
        return answer;
    }
}
