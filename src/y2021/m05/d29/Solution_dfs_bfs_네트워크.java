package y2021.m05.d29;

public class Solution_dfs_bfs_네트워크 {
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(solution(n, computers));
	}
	public static boolean visit[];
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                answer++;
                dfs(i,computers,n);
            }
        }
        return answer;
    }
    public static void dfs(int curr,int[][] computers, int n){
        visit[curr]=true;
        for(int i=0;i<n;i++){
            if(computers[curr][i]==1&&!visit[i]){
                dfs(i,computers,n);
            }
        }
    }
}

