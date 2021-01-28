package y2021.m01.d04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
*/

class Main_bj_1238_파티 {
	public static int N,M,X,graph[][];
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	X = Integer.parseInt(st.nextToken());
    	graph = new int[N+1][N+1];
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int ni = Integer.parseInt(st.nextToken());
    		int nj = Integer.parseInt(st.nextToken());
    		int input = Integer.parseInt(st.nextToken());
    		graph[ni][nj]=input;
    	}
    	
    	int outdis[] = new int[N+1];
    	int indis[] = new int[N+1];
    	boolean outvisit[] = new boolean[N+1];
    	boolean invisit[] = new boolean[N+1];
    	
    	for(int i=0;i<N+1;i++) {
    		outdis[i]=Integer.MAX_VALUE;
    		indis[i]=Integer.MAX_VALUE;
    	}
    	
    	outdis[X]=0;
    	indis[X]=0;
    	outvisit[X]=true;
    	invisit[X]=true;
    	
    	for(int i=1;i<N+1;i++) {
    		if(!outvisit[i]&&graph[X][i]!=0) {
    			outdis[i]=graph[X][i];
    		}
    		if(!invisit[i]&&graph[i][X]!=0) {
    			indis[i]=graph[i][X];
    		}
    	}
    	
    	for(int i=0;i<N-1;i++) {
    		int outmin = Integer.MAX_VALUE;
    		int outmin_index = -1;
    		int inmin = Integer.MAX_VALUE;
    		int inmin_index = -1;
    		
    		for(int j=1;j<N+1;j++) {
    			if(!outvisit[j] && outdis[j]!=Integer.MAX_VALUE) {
    				if(outdis[j]<outmin) {
    					outmin=outdis[j];
    					outmin_index=j;
    				}
    			}
    			if(!invisit[j] && indis[j]!=Integer.MAX_VALUE) {
    				if(indis[j]<inmin) {
    					inmin=indis[j];
    					inmin_index=j;
    				}
    			}
    		}
    		
    		outvisit[outmin_index] = true;
    		invisit[inmin_index] = true;
    		for(int j=1;j<N+1;j++) {
    			if(!outvisit[j]&&graph[outmin_index][j]!=0) {
    				if(outdis[j]>outdis[outmin_index]+graph[outmin_index][j]) {
    					outdis[j]=outdis[outmin_index]+graph[outmin_index][j];
    				}
    			}
    			if(!invisit[j]&&graph[j][inmin_index]!=0) {
    				if(indis[j]>indis[inmin_index]+graph[j][inmin_index]) {
    					indis[j]=indis[inmin_index]+graph[j][inmin_index];
    				}
    			}
    		}
    		
    	}
    	int answer = 0;
    	for(int i=1;i<N+1;i++) {
    		if(outdis[i]+indis[i]>answer) {
    			answer = outdis[i]+indis[i];
    		}
    	}
    	System.out.println(answer);
	}
}
