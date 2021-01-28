package y2020.m09.d04;


/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/
public class Solution_pro_깊이너비우선탐색_네트워크 {
	public static void main(String[] args) throws Exception {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution(n,computers));
	}

	public static boolean visit[];
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        int N = computers.length;
        visit = new boolean[N];
        for(int i=0;i<N;i++) {
        	if(!visit[i]) {
        		visit[i]=true;
        		dfs(i,N,computers);
        		answer++;
        	}
        }
        return answer;
    }

	private static void dfs(int i, int N, int[][] computers) {
		for(int j=0;j<N;j++) {
			if(!visit[j]&&computers[i][j]==1) {
				visit[j]=true;
				dfs(j,N,computers);
			}
		}
	}
}
