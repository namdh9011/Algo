package y2020.m07.d08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10830_행렬제곱_남동해 {
	public static int N, A[][];
	public static long B;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_BJ_10830.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
	}
}
