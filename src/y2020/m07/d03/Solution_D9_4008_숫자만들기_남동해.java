package y2020.m07.d03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D9_4008_숫자만들기_남동해 {
	public static int N,comm[],data[],cal[],min,max;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D9_4008.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			N=Integer.parseInt(br.readLine());
			comm = new int[4];
			data = new int[N];
			cal = new int[N-1];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				comm[i]=Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				data[i]=Integer.parseInt(st.nextToken());
			}
			
			dfs(0);
			int a = max-min;
			System.out.println("#" + tc + " " + a);
		}
	}
	private static void dfs(int cnt) {
		if(cnt==N-1) {
			solve();
			return;
		}
		for(int i=0;i<4;i++) {
			if(comm[i]>0) {
				comm[i]--;
				cal[cnt]=i;
				dfs(cnt+1);
				comm[i]++;
			}
		}
	}
	
	private static void solve() {
		int result = data[0];
		for(int i=0;i<N-1;i++) {
			result = cal(result,data[i+1],cal[i]);
		}
		if(result>max) {
			max=result;
		}
		if(result<min) {
			min=result;
		}
	}
	
	private static int cal(int x, int y, int comm) {
		if(comm==0) {
			return x+y;
		}else if(comm==1) {
			return x-y;
		}else if(comm==2) {
			return x*y;
		}else {
			return x/y;
		}
	}
}