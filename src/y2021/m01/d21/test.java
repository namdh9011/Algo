package y2021.m01.d21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
/*
3 6
antarctica
antahellotica
antacartica
 */


class test {
	public static boolean visit[];
	public static int answer,co[],K,N;
	public static void main(String[] args) throws Exception {
		N=5;
		K=3;
		visit = new boolean[N];
		co = new int[K];
		comb(0,K,N,0);
	}
	
	
	private static void comb(int count, int K, int N,int start) {
		if(count==K) {
			System.out.println(Arrays.toString(co));
			return;
		}
		for(int i=start;i<N;i++) {
			co[count]=i;
			comb(count+1,K,N,i+1);
		}
	}
}
