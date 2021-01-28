package y2020.m09.d23;

import java.util.*;

public class Solution_pro_그래프_가장먼노드 {
	public static void main(String[] args) throws Exception{
		int n = 6;
		int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		System.out.println(solution(n,edge));
	}

	public static ArrayList<Integer> al[];
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        al = new ArrayList[n+1];
        
        for(int i=1;i<=n;i++) {
        	al[i] = new ArrayList<>();
        }
        for(int i=0;i<edge.length;i++) {
        	al[edge[i][0]].add(edge[i][1]);
        	al[edge[i][1]].add(edge[i][0]);
        }
        
        answer = bfs(n,1);
        
        return answer;
    }
	private static int bfs(int n, int start) {
		int max = 0;
		int count = 0;
		boolean[] visit = new boolean[n+1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start,0});
		visit[start]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int node = curr[0];
			int dis = curr[1];
			for(int i=0;i<al[node].size();i++) {
				int next = al[node].get(i);
				if(!visit[next]) {
					visit[next]=true;
					if(max<dis+1) {
						max=dis+1;
						count=1;
					}else if(max==dis+1) {
						count++;
					}
					q.add(new int[] {next, dis+1});
				}
			}
		}
		return count;
	}
}
