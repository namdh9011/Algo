package y2021.m02.d05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5 21
5 6 7 8 9
 */


class Main_bj_2798_블랙잭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] card = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			card[i]=Integer.parseInt(st.nextToken());
		}
		int answer = dfs(card,N,M,0,0,0,0);
		System.out.println(answer);
	}

	private static int dfs(int[] card, int N, int M,int count ,int start, int sum, int max) {
		if(sum>M) {
			return max;
		}
		if(count==3) {
			if(sum>max) {
				max=sum;
			}
			return max;
		}
		for(int i=start;i<N;i++) {
			max=dfs(card, N,M,count+1,i+1,sum+card[i],max);
		}
		return max;
	}
}