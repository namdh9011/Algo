package y2021.m09.d11;

import java.util.Arrays;

public class Solution_pro_카카오4 {
	public static void main(String[] args) {
		int n = 10;
		int[] info = {0,0,0,0,0,0,0,0,3,4,3};
		System.out.println(Arrays.toString(solution(n,info)));
	}
	
	public static boolean flag;
	public static int a[],N,K, answer[], max;
	public static int[] solution(int n, int[] info) {
		N = 11;
		K = n;
		max = Integer.MIN_VALUE;
        answer = new int[N];
        a = new int[N];
        comb(info, 0, 0);
        if(!flag) {
        	return new int[] {-1};
        }
        return answer;
    }
	private static void comb(int[] info, int count, int start) {
		if(count==K) {
			//info a 비교
			System.out.println(Arrays.toString(a));
			for(int i=0;i<N;i++) {
				int cal = calScore(info);
				if(cal>0&&cal>=max) {
					flag=true;
					max=cal;
					for(int j=0;j<N;j++) {
						answer[j]=a[j];
					}
				}
			}
			return;
		}
		for(int i=start;i<N;i++) {
			a[i]++;
			comb(info, count+1, i);
			a[i]--;
		}
	}
	private static int calScore(int[] info) {
		int apsum = 0;
		int lisum = 0;
		for(int i=0;i<N;i++) {
			int apscore = info[i];
			int liscore = a[i];
			if(apscore==0&&liscore==0) {
				continue;
			}
			if(apscore>=liscore) {
				apsum+=10-i;
			}else {
				lisum+=10-i;
			}
		}
		return lisum-apsum;
	}
}
