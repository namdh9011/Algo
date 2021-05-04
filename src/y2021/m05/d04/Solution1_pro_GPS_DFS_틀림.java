package y2021.m05.d04;

import java.util.ArrayList;
/*
- 틀림 DP로 풀어야함.
 */
public class Solution1_pro_GPS_DFS_틀림 {
	public static void main(String[] args) {
		int n = 7; 
		int m = 10;
		int[][] edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}}; 
		int k = 6; 
		int[] gps_log = {1,2,3,3,6,7};
		System.out.println(solution(n,m,edge_list,k,gps_log));
	}
	public static ArrayList<ArrayList<Integer>> tree;
	public static int min;
    public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        min = Integer.MAX_VALUE;
        tree = new ArrayList<>();
        for(int i=0;i<=n;i++){
            tree.add(new ArrayList<Integer>());
        }
        int[] dest = new int[k];
        for(int i=0;i<m;i++){
            tree.get(edge_list[i][0]).add(edge_list[i][1]);
            tree.get(edge_list[i][1]).add(edge_list[i][0]);
        }
        dest[0]=gps_log[0];
        dfs(gps_log[0],1,gps_log, k, dest, 0);
        answer = min;
        return answer;
    }
    public static void dfs(int start, int count, int[] gps_log, int k, int[] dest, int cnt){
    	if(count==k){
        	if(dest[k-1]==gps_log[k-1]) {
        		if(min>cnt) {
        			min=cnt;
        		}
        	}
            return;
        }
        ArrayList<Integer> curr = tree.get(start);
        int n = curr.size();
        for(int i=0;i<n;i++){
            dest[count]=curr.get(i);
            if(gps_log[count]!=dest[count]) {
            	dfs(curr.get(i), count+1, gps_log, k, dest, cnt+1);
            }else {
            	dfs(curr.get(i), count+1, gps_log, k, dest, cnt);
            }
        }
    }
}
