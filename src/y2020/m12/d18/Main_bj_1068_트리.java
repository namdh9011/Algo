package y2020.m12.d18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
5
-1 0 0 1 1
2
 */

class Main_bj_1068_트리 {
	public static ArrayList<Integer>[] al;
	public static int result;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	al = new ArrayList[N];
    	for(int i=0;i<N;i++) {
    		al[i]=new ArrayList<>();
    	}
    	int root=0;
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		int temp = Integer.parseInt(st.nextToken());
    		if(temp==-1) {
    			root = i;
    		}
    		if(temp!=-1) {
    			al[temp].add(i);
    		}
    	}
    	int tar = Integer.parseInt(br.readLine());
    	
    	if(tar==root) {		//루트가 삭제될 경우 예외처리
    		System.out.println(0);
    	}else {
    		dfs(root, tar);
    		System.out.println(result);
    	}
    }

	private static void dfs(int curr, int tar) {
		for(int i=0;i<al[curr].size();i++) {
			int cu = al[curr].get(i);
			if(cu==tar) {
				if(al[curr].size()==1) {	//1직선일 경우 예외처리
					result++;
				}
				continue;
			}
			if(al[cu].size()==0) {
				result++;
			}else {
				dfs(cu,tar);
			}
		}
	}
}
