package y2021.m09.d11;

import java.util.Arrays;

public class Solution_pro_카카오4_2 {
	public static void main(String[] args) {
		int n = 5;
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		System.out.println(Arrays.toString(solution(n,info)));
	}
	
	public static boolean visit[], flag;
	public static int a[],N,K, answer[], max;
	public static int[] solution(int n, int[] info) {
		N = 10;
		K = n;
        answer = new int[N+1];
        visit = new boolean[N+1];
        for(int i=1;i<=K;i++) {
        	a = new int[i];
        	comb(0, i);
        }
        return answer;
    }
	private static void comb(int count, int esc) {
		if(count==K) {
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=0;i<esc;i++) {
			a[i]++;
			comb(count+1, esc);
			a[i]--;
		}
	}
}
