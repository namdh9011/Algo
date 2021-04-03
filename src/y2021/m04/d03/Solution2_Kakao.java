package y2021.m04.d03;

public class Solution2_Kakao {

	public static void main(String[] args) {
		int[][] needs = { { 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1} };
//		int[][] needs = new int[1000][15];
		int r = 2;
		System.out.println(solution(needs, r));
	}
	public static int max;			
	public static boolean parts[];
	public static int solution(int[][] needs, int r) {
        parts = new boolean[needs[0].length];	//부품 보유하고 있으면 true
        max = 0;								//최대 완제품 개수
//        if(r>=needs[0].length) {
//        	max = needs.length;
//        }else {
        	comb(needs, r, 0, 0);					//부품 combination
//        }
        return max;
    }
	private static void comb(int[][] needs, int r, int count, int start) {
		if(count==r) {							//r개만큼 부품을 고름
			max = Math.max(max,solve(needs));
			return;
		}
		for(int i=start;i<needs[0].length;i++) {
			parts[i]=true;
			comb(needs, r, count+1, i+1);
			parts[i]=false;
		}
	}
	private static int solve(int[][] needs) {
		int count=0;
		here:for(int i=0;i<needs.length;i++) {
			for(int j=0;j<needs[0].length;j++) {
				if(needs[i][j]==1&&!parts[j]) {		//필요한 부품이 없으면 다음 제품으로
					continue here;
				}
			}
			count++;								//필요한 부품이 다있으면 완제품 카운트 늘려 줌.
		}
		return count;
	}
}
