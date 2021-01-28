package y2020.m12.d03.cos_pro;
// You may use import as below.
//import java.util.*;

class Solution3 {
    public int solution(String pos) {
        // Write code here.
    	int answer = 0;
    	int[] di = {-2,-2,-1,-1,1,1,2,2};
    	int[] dj = {-1,1,-2,2,-2,2,-1,1};
    	int i = 8-(pos.charAt(1)-'0');
    	int j = pos.charAt(0)-'A';
    	System.out.println(i + " " + j);
    	for(int d=0;d<8;d++) {
    		int ni = i + di[d];
    		int nj = j + dj[d];
    		if(ni>=0&&nj>=0&&ni<8&&nj<8) {
    			answer++;
    		}
    	}
        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        String pos = "H1";
        int ret = sol.solution(pos);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}