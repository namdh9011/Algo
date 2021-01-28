package y2020.m12.d04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
3
1234 3412
1000 1
1 16
 */

class Main_bj_9019_DSLR_class {
	public static boolean visit[];
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	for(int tc=0;tc<T;tc++)	{
    		visit = new boolean[10000];
    		st = new StringTokenizer(br.readLine());
    		int A = Integer.parseInt(st.nextToken());
    		int B = Integer.parseInt(st.nextToken());
    		sb.append(bfs(A,B)).append("\n");
    	}
    	System.out.println(sb.toString());
    }
	private static String bfs(int a, int b) {
		Queue<Pair> q = new LinkedList<>();
		visit[a]=true;
		q.add(new Pair(a, "D"));
		q.add(new Pair(a, "S"));
		q.add(new Pair(a, "L"));
		q.add(new Pair(a, "R"));
		while(!q.isEmpty()) {
			Pair curr = q.poll();
			String stemp = curr.com;
			int temp = dslr(curr.num, stemp.charAt(stemp.length()-1));
			
			if(temp==b) {
				return stemp;
			}
			if(!visit[temp]) {
				visit[temp]=true;
				q.add(new Pair(temp, stemp+"D"));
				q.add(new Pair(temp, stemp+"S"));
				q.add(new Pair(temp, stemp+"L"));
				q.add(new Pair(temp, stemp+"R"));
			}
		}
		return null;
	}

	private static int dslr(int num, char com) {
		if(com=='D') {
			return (num*2)%10000;
		}else if(com=='S') {
			if(num==0) {
				return 9999;
			}else {
				return num-1;
			}
		}else if(com=='L') {
			String s = Integer.toString(num);
			int len = s.length();
			for(int i=0;i<4-len;i++) {
				s = "0" + s;
			}
			s = s.substring(1)+s.charAt(0);
			return Integer.parseInt(s);
		}else {
			String s = Integer.toString(num);
			int len = s.length();
			for(int i=0;i<4-len;i++) {
				s = "0" + s;
			}
			s = s.charAt(3)+s.substring(0,3);
			return Integer.parseInt(s);
		}
	}
	static class Pair{
		int num;
		String com;
		Pair(int num, String com){
			this.num = num;
			this.com = com;
		}
	}
}