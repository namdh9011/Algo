package y2020.m10.d29;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_파수_3 {
	public static void main(String[] args) throws Exception {
		int[][] parking = {{1,2},{3,4},{5,6},{-1,8},{9,10},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
//		int[][] parking = {{1,2},{3,4},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
		
		System.out.println(solution(parking));
	}
	
	public static boolean visit[];
	public static int count;
	public static int solution(int[][] parking) {
        count=0;
        int result = 0;
        int answer = 0;
        visit = new boolean[parking.length*2+1];
        for(int i=0;i<parking.length;i++) {
			int left = parking[i][0];
			int right = parking[i][1];
			if(left!=-1) {
				dfs(parking, right);
			}
			result=count;
			count=0;
			if(right!=-1) {
				dfs(parking, left);
			}
			result*=count;
			answer+=result;
			count=0;
        }
        return answer;
    }

	private static void dfs(int[][] parking, int tar) {
		if(tar==-1) {
			return;
		}
		count++;
		int nleft = parking[tar][0];
		int nright = parking[tar][1];
		if(nleft!=-1) {
			dfs(parking,nleft);
		}
		if(nright!=-1) {
			dfs(parking,nright);
		}
	}
}
