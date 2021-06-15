package y2021.m06.d04;

import java.util.ArrayList;
/*
메모리 : 11528 KB
시간 : 72 ms

최적 메모리 : 12648 KB
최적 시간 : 64 ms
*/
/*

 */
public class Main_bj_4673_셀프넘버 {
	public static int N;
	public static boolean[] visit;
	public static void main(String[] args) throws Exception {
		N = 10000;
		visit = new boolean[N+1];
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			if(!visit[i]) {
				al.add(i);
				check(i);
			}
		}
		int size = al.size();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<size;i++) {
			sb.append(al.get(i)).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void check(int a) {
		if(a>10000||visit[a]) return;
		visit[a]=true;
		int ret = a;
		while(a>0) {
			ret+=a%10;
			a/=10;
		}
		check(ret);
	}
}


