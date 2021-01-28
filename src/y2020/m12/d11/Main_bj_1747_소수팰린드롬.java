package y2020.m12.d11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
7
1
5
2
10
-99
7
5
 */

class Main_bj_1747_소수팰린드롬 {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	here : for(int curr=N;curr<1003002;curr++) {
    		if(prime(curr)) {
    			String temp = Integer.toString(curr);
    			for(int i=0;i<temp.length()/2;i++) {
    				if(temp.charAt(i)!=temp.charAt(temp.length()-i-1)) {
    					continue here;
    				}
    			}
    			System.out.println(curr);
    			break;
    		}
    	}
    }

	private static boolean prime(int curr) {
		if(curr<2) return false;
		for(int i=2;i*i<=curr;i++) {
			if(curr%i==0) {
				return false;
			}
		}
		return true;
	}
}
