package y2021.m03.d28;
public class Solution_pro_코테1 {
	public static void main(String[] args) throws Exception {
		int n = 125;
		System.out.println(Solution(n));
	}

	private static int Solution(int n) {
		int answer = 0;
		while(n>=1) {
			n/=5;
			answer+=n;
		}
		return answer;
	}
}
