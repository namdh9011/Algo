package y2021.m04.d24;

import java.util.*;
public class Solution3_nav {

	public static void main(String[] args) {
//		int n = 19;
//		int[][] edges = {{0,1},{0,2},{0,3},{1,4},{1,5},{2,6},{3,7},{3,8},{3,9},{4,10},{4,11},{5,12},{5,13},{6,14},{6,15},{6,16},{8,17},{8,18}};
//		int n = 14;
//		int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{2,7},{3,8},{3,9},{3,10},{4,11},{4,12},{4,13}};
		int n = 10;
		int[][] edges = {{0,1},{0,2},{1,3},{2,4},{2,5},{2,6},{3,7},{3,8},{3,9}};
		System.out.println(solution(n,edges));
	}
	public static ArrayList<ArrayList<Integer>> tree;
	public static int min;
	private static int solution(int n, int[][] edges) {
		tree = new ArrayList<>();
		min = Integer.MAX_VALUE;
		for(int i=0;i<=n;i++) {
			tree.add(new ArrayList<>());
		}
		for(int i=0;i<edges.length;i++) {
			ArrayList<Integer> curr = tree.get(edges[i][0]);
			curr.add(edges[i][1]);
		}
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(0);
		dfs(arr,1);
		return min;
	}
	private static void dfs(ArrayList<Integer> arr, int count) {
		ArrayList<Integer> next = new ArrayList<>();
		for(int i=0;i<arr.size();i++) {
			ArrayList<Integer> curr = tree.get(arr.get(i));
			for(int j=0;j<curr.size();j++) {
				next.add(curr.get(j));
			}
		}
		if(next.size()==0) {
			if(min>count) {
				min=count;
			}
		}
		for(int i=0;i<next.size();i++) {
			ArrayList<Integer> curr = new ArrayList<>();
			for(int j=0;j<next.size();j++) {
				if(i!=j) {
					curr.add(next.get(j));
				}
			}
			dfs(curr, count+curr.size());
		}
	}
}
