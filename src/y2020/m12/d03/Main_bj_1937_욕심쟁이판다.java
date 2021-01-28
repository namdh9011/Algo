package y2020.m12.d03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_bj_1937_욕심쟁이판다 {
	public static int[][] dp,map;
	public static int[] di = {-1,0,1,0}, dj = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	int sol = 0;
    	int N = Integer.parseInt(br.readLine());
    	map = new int[N][N];
    	dp = new int[N][N];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<N;j++) {
    			map[i][j]=Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			if(dp[i][j]==0) {
    				int temp = dfs(i,j,N,1,0);
    				dp[i][j]=temp;
    				if(temp>sol) {
    					sol=temp;
    				}
    			}
    		}
    	}
    	for(int i=0;i<N;i++) {
    		System.out.println(Arrays.toString(dp[i]));
    	}
    	System.out.println(sol);
    }
    public static int dfs(int i, int j, int N, int count, int max) {
    	for(int d=0;d<4;d++) {
    		int ni = i + di[d];
    		int nj = j + dj[d];
    		if(ni>=0&&nj>=0&&ni<N&&nj<N) {
    			if(map[ni][nj]>map[i][j]) {
//    				if(dp[ni][nj]!=0) {
    					max = dfs(ni,nj,N,count+1,max);
    					dp[ni][nj]=max-count;
//    				}
    			}
    			if(count>max) {
    				max=count;
    			}
    		}
    	}
    	return max;
    }
}