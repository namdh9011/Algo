package y2020.m09.d25;

public class Solution_엔테크_2번 {
	public static void main(String[] args) throws Exception{
		int N = 5;
		System.out.println(solution(N));
	}

	public static int solution(int N) {
		int answer = 0;
		answer = dfs(N);
        return answer;
    }

	private static int dfs(int N) {
		if(N==1) {
			return 1;
		}else if(N==2) {
			return 2;
		}else {
			return dfs(N-1)+dfs(N-2);
		}
	}
}