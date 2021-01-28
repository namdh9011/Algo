package y2020.m09.d04;


/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/
public class Solution_pro_깊이너비우선탐색_타겟넘버 {
	public static void main(String[] args) throws Exception {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers,target));
	}

	public static int num[],K,T,sum,answer;
	public static int solution(int[] numbers, int target) {
        answer = 0;
        sum = 0;
        num = numbers;
        K = numbers.length;
        T = target;
        
        dfs(0);
        return answer;
    }

	private static void dfs(int count) {
		if(count==K) {
			System.out.println(sum);
			if(sum==T) {
				answer++;
			}
			return;
		}
		sum+=num[count];
		dfs(count+1);
		sum-=num[count];
		sum-=num[count];
		dfs(count+1);
		sum+=num[count];
	}
}
