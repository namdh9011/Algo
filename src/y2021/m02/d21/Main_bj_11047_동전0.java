package y2021.m02.d21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
10 4200
1
5
10
50
100
500
1000
5000
10000
50000
 */

class Main_bj_11047_동전0 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0;i<N;i++) {
			int input = Integer.parseInt(br.readLine());
			if(input<=K) {
				al.add(input);
			}
		}
		int len = al.size();
		int answer = 0;
		for(int i=0;i<len;i++) {
			int curr = al.get(len-i-1);
			answer+=K/curr;
			K%=curr;
			if(K==0) {
				break;
			}
		}
		System.out.println(answer);
	}
}