package y2020.m10.d25;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_파수_3 {
	public static void main(String[] args) throws Exception {
		int[][] parking = {{1,2},{3,4},{5,6},{-1,8},{9,10},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};	//false
//		int[][] parking = {{1,2},{3,4},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};	//false
		
		System.out.println(solution(parking));
	}
	
	public static boolean visit[];
	public static int count;
	public static int solution(int[][] parking) {
        int answer = 0;
        count=0;
        visit = new boolean[parking.length*2+1];
        for(int i=0;i<parking.length;i++) {
			int left = parking[i][0];
			int right = parking[i][1];
			if(left!=-1) {
				visit[left]=true;
				dfs(parking, 2);
				visit[left]=false;
			}
			if(right!=-1) {
				visit[right]=true;
				dfs(parking, 1);
				visit[right]=false;
			}
        }
        System.out.println(count);
        return answer;
    }

	private static void dfs(int[][] parking, int tar) {
		if(tar==-1) {
			return;
		}
		System.out.println(tar);
		count++;
		int nleft = parking[tar][0];
		int nright = parking[tar][1];
		dfs(parking,nleft);
		dfs(parking,nright);
	}
}
