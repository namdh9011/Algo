package y2020.m09.d27;

import java.util.*;
public class Solution_pro_네이버코테 {
	public static Queue<Integer> q, tar;
	public static void main(String[] args) {
		int n = 19;
		q = new LinkedList<Integer>();
		tar = new LinkedList<Integer>();
		int[][] edges = {{0,1},{0,2},{0,3},{1,4},{1,5},{2,6},{3,7},{3,8},{3,9},{4,10},{4,11},{5,12},{5,13},{6,14},{6,15},{6,16},{8,17},{8,18}};
//		for(int i=0;i<edges.length;i++) {
//			boolean[] uncon = new boolean[n];
//			if(edges[i][0]==0) {
//				uncon[edges[i][1]]=true;
//				uncon[edges[i][1]]=true;
//				dfs(0,uncon,edges);
//			}
//		}
		
		tar.add(0);
		while(!tar.isEmpty()) {
			boolean[] uncon = new boolean[n];
			int t = tar.poll();
			uncon[t]=true;
			q.add(t);
			while(!q.isEmpty()) {
				int curr = q.poll();
				System.out.println("curr" + curr);
				uncon[curr]=true;
				dfs(0,uncon,edges);
				uncon[curr]=false;
			}
		}
	}

	public static void dfs(int num, boolean[] uncon,int[][] edges) {
		System.out.println(num);
		for(int i=0;i<edges.length;i++) {
			if(edges[i][0]==num) {
				if(!uncon[edges[i][1]]) {
					uncon[edges[i][1]]=true;
					q.add(edges[i][1]);
					dfs(edges[i][1],uncon,edges);
				}
			}
		}
	}
	
}
