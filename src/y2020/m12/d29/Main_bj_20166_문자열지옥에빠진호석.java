package y2020.m12.d29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
3 3 3
aaa
aba
aaa
aa
bb
a
*/

class Main_bj_20166_문자열지옥에빠진호석 {
	public static int N,M,K,di[]= {-1,-1,-1,0,1,1,1,0}, dj[]= {-1,0,1,1,1,0,-1,-1};
	public static char map[][];
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	HashMap<String,Integer> hm = new HashMap<>();
    	StringBuilder sb = new StringBuilder();
    	map = new char[N][M];
    	for(int i=0;i<N;i++) {
    		String input = br.readLine();
    		for(int j=0;j<M;j++) {
    			map[i][j] = input.charAt(j);
    		}
    	}
    	for(int i=0;i<K;i++) {
    		String input = br.readLine();
    		if(hm.get(input)==null) {
    			int count = bfs(input); 
    			hm.put(input, count);
    			sb.append(count).append("\n");
    		}else {
    			sb.append(hm.get(input)).append("\n");
    		}
    	}
    	System.out.println(sb.toString());
	}
    
	private static int bfs(String input) {
		int cnt=0;
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(input.charAt(0)==map[i][j]) {
					q.add(new int[] {i,j,1});
				}
			}
		}
		
		if(input.length()==1) {
			cnt = q.size();
		}else {
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				for(int d=0;d<8;d++) {
					int ni = (curr[0] + di[d] + N)%N;
					int nj = (curr[1] + dj[d] + M)%M;
					if(map[ni][nj]==input.charAt(curr[2])) {
						if(curr[2]==input.length()-1) {
							cnt++;
						}else {
							q.add(new int[] {ni,nj,curr[2]+1});
						}
					}
				}
			}
		}
		return cnt;
	}
}
