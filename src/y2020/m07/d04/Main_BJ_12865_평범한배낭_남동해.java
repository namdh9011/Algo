package y2020.m07.d04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_12865_평범한배낭_남동해{
	public static int N,K,w[],v[],table[][];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_BJ_12865.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//물품의 수
		K = Integer.parseInt(st.nextToken());	//최대 무게
		w = new int[N];							//물건의 무게
		v = new int[N];							//물건의 가치
		table = new int[N+1][K+1];				//DP table
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			w[i]=Integer.parseInt(st.nextToken());
			v[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<K+1;j++) {
				if(w[i-1]>j) {
					table[i][j]=table[i-1][j];
				}else {
					table[i][j]=max(table[i-1][j], v[i-1]+table[i-1][j-w[i-1]]);
				}
			}
		}
		System.out.println(table[N][K]);
	}
	private static int max(int i, int j) {
		if(i>j) {
			return i;
		}else {
			return j;
		}
	}
}