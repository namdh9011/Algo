package y2020.m12.d03.cos_pro;
// You may use import as below.
//import java.util.*;

class Solution1 {
    public long solution(long num) {
        // Write code here.
    	num++;
    	String s = Long.toString(num);
    	s = s.replace('0', '1');
        long answer = Long.parseLong(s);
        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
    	Solution1 sol = new Solution1();
    	long num = 9949999;
    	long ret = sol.solution(num);
    	
    	// Press Run button to receive output. 
    	System.out.println("Solution: return value of the method is " + ret + " .");
    }
}