package y2021.m01.d30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5
55 185
58 183
88 186
60 175
46 155
 */


class Main_bj_7568_덩치 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] data = new int[N][2];
		int[] result = new int[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			data[i][0]=Integer.parseInt(st.nextToken());
			data[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j&&data[i][0]<data[j][0]&&data[i][1]<data[j][1]) {
					result[i]++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			sb.append(result[i]+1).append(" ");
		}
		System.out.println(sb.toString());
	}
}