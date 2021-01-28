package y2020.m12.d03.cos_pro;
// You may use import as below.
//import java.util.*;

import java.util.Arrays;

class Solution2 {
    public int solution(int n) {
        // Write code here.
    	int[][] map = new int[n][n];
    	int di[] = {0,1,0,-1};
    	int dj[] = {1,0,-1,0};
    	int x = 0;
    	int y = 0;
    	int count = 1;
    	map[x][y] = count;
    	int d = 0;
    	while(true) {
    		if(count==n*n) {
    			break;
    		}
    		int ni = x+di[d];
    		int nj = y+dj[d];
    		if(ni>=0&&nj>=0&&ni<n&&nj<n&&map[ni][nj]==0) {
    			count++;
    			map[ni][nj]=count;
    			x=ni;
    			y=nj;
    		}else {
    			d++;
    			if(d==4) {
    				d=0;
    			}
    		}
    	}
    	for(int i=0;i<n;i++) {
    		System.out.println(Arrays.toString(map[i]));
    	}
        int answer = 0;
        for(int i=0;i<n;i++) {
        	answer+=map[i][i];
        }
        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int n1 = 100;
        int ret1 = sol.solution(n1);

        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret1 + " .");
        
        int n2 = 2;
        int ret2 = sol.solution(n2);
        
        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret2 + " .");
    }
}