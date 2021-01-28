package y2020.m09.d23;

import java.util.ArrayList;
class Solution_pro_그래프_순위 {
	public static void main(String[] args) {
		int n = 5;
		int results[][] = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(n,results));
	}
    public static ArrayList<Integer>[] win,lose;
    public static boolean visit[];
    public static int count;
    public static int solution(int n, int[][] results) {
        int answer = 0;
        win = new ArrayList[n+1];
        lose = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            win[i]=new ArrayList<>();
            lose[i]=new ArrayList<>();
        }
        
        for(int i=0;i<results.length;i++){
            int winp = results[i][0];
            int losep = results[i][1];
            win[winp].add(losep);
            lose[losep].add(winp);
        }
        
        for(int i=1;i<=n;i++){
            visit = new boolean[n+1];
            visit[i]=true;
            count=0;
            windfs(i);
            losedfs(i);
            if(count==n-1){
                answer++;
            }
        }
        return answer;
    }
    public static void windfs(int p){
        for(int i=0;i<win[p].size();i++){
            int curr = win[p].get(i);
            if(!visit[curr]){
                visit[curr]=true;
                count++;
                windfs(curr);
            }
        }
    }
    
    public static void losedfs(int p){
        for(int i=0;i<lose[p].size();i++){
            int curr = lose[p].get(i);
            if(!visit[curr]){
                visit[curr]=true;
                count++;
                losedfs(curr);
            }
        }
    }
}