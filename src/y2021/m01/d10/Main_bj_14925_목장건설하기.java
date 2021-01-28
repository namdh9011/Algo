package y2021.m01.d10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
6 6
0 0 0 1 0 0
0 0 0 2 1 0
0 0 2 0 0 0
0 1 0 0 0 0
2 0 0 0 0 0
0 0 0 0 0 0
*/

class Main_bj_14925_목장건설하기 {
	public static int M,N,map[][],max;
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	map = new int[N][M];
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			map[i][j]=Integer.parseInt(st.nextToken());
    		}
    	}
    	max = 0;
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<M;j++) {
    			int temp = checkSize(i,j);
    			if(temp>max) {
    				max = temp;
    			}
    		}
    	}
    	System.out.println(max);
	}
	private static int checkSize(int ni, int nj) {
		int size = max;
		here : while(true) {
			if(ni+size>=N||nj+size>=M) {
				break;
			}
			for(int i=ni;i<=ni+size;i++) {
				for(int j=nj;j<=nj+size;j++) {
					if(map[i][j]!=0) {
						break here;
					}
				}
			}
			size++;
		}
		return size;
	}
}
