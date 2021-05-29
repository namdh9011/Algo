package y2021.m05.d29;

public class Solution_dfs_bfs_타겟넘버 {
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	public static boolean visit[];
    public static int answer;
    public static int solution(int[] numbers, int target) {
        answer = 0;
        int n = numbers.length;
        visit = new boolean[n];
        dfs(n,target,0,0,numbers);
        return answer;
    }
    public static void dfs(int n, int target, int count, int sum, int[] numbers){
        if(count==n){
            if(sum==target){
                answer++;
            }
            return;
        }
        dfs(n,target,count+1,sum+numbers[count],numbers);
        dfs(n,target,count+1,sum-numbers[count],numbers);
    }
}

