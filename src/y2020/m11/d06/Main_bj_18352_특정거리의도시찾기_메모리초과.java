package y2020.m11.d06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
4 4 2 1
1 2
1 3
2 3
2 4
 */
public class Main_bj_18352_특정거리의도시찾기_메모리초과 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] al = new ArrayList[N+1];
		Queue<int[]> q = new LinkedList<>();
		int[] dest = new int[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int curr = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			if(al[curr]==null) {
				al[curr] = new ArrayList<Integer>();
			}
			if(curr==X) {
				q.add(new int[] {next, 1});
				dest[next]=1;
			}
			al[curr].add(next);
		}
//		System.out.println(Arrays.toString(al));
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int curr = temp[0];
			int dis = temp[1];
			if(dis>=K) {
				break;
			}
			if(al[curr]==null) {
				continue;
			}
			for(int i=0;i<al[curr].size();i++) {
				int next = al[curr].get(i);
				if(dest[next]==0) {
					dest[next]=dis+1;
				}
				if(dis+1<K) {
					q.add(new int[] {next, dis+1});
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<dest.length;i++) {
			if(dest[i]==K) {
				sb.append(i).append("\n");
			}
		}
		if(sb.toString().equals("")) {
			System.out.println(-1);
		}else {
			System.out.println(sb.toString());
		}
	}
}
