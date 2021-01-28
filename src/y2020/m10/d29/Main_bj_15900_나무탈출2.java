package y2020.m10.d29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
8
8 1
1 4
7 4
6 4
6 5
1 3
2 3
 */
public class Main_bj_15900_나무탈출2 {
	public static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] al = new ArrayList[N+1];
		count=0;
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(al[a]==null) {
				al[a] = new ArrayList<>();
				al[a].add(b);
			}else {
				al[a].add(b);
			}
			if(al[b]==null) {
				al[b] = new ArrayList<>();
				al[b].add(a);
			}else {
				al[b].add(a);
			}
		}
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<al[1].size();i++) {
			q.add(new int[] {1,al[1].get(i),1});
		}
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			boolean f = false;
			for(int i=0;i<al[curr[1]].size();i++) {
				if(curr[0]!=al[curr[1]].get(i)) {
					q.add(new int[] {curr[1], al[curr[1]].get(i), curr[2]+1});
					f=true;
				}
			}
			if(!f) {
				count+=curr[2];
			}
		}
		if(count%2==0) {
			System.out.println("No");
		}else {
			System.out.println("Yes");
		}
	}
}
