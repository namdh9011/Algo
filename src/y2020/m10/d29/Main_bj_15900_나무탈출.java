package y2020.m10.d29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
public class Main_bj_15900_나무탈출 {

	public static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		ArrayList<Integer> temp = null;
		count=0;
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(map.get(a)==null) {
				ArrayList<Integer> nal = new ArrayList<>();
				nal.add(b);
				map.put(a, nal);
			}else {
				temp = map.get(a);
				temp.add(b);
				map.put(a, temp);
			}
			if(map.get(b)==null) {
				ArrayList<Integer> nal = new ArrayList<>();
				nal.add(a);
				map.put(b, nal);
			}else {
				temp = map.get(b);
				temp.add(a);
				map.put(b, temp);
			}
		}
		Queue<int[]> q = new LinkedList<>();
		temp = map.get(1);
		for(int i=0;i<temp.size();i++) {
			q.add(new int[] {1,temp.get(i),1});
		}
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			temp = map.get(curr[1]);
			boolean f = false;
			for(int i=0;i<temp.size();i++) {
				if(curr[0]!=temp.get(i)) {
					q.add(new int[] {curr[1], temp.get(i), curr[2]+1});
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
