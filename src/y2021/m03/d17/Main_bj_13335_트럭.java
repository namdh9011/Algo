package y2021.m03.d17;

import java.util.*;
import java.io.*;
/*
5 4 10
7 4 5 5 6
 */
public class Main_bj_13335_트럭 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Queue<int[]> onBridge = new LinkedList<>();
		int weightsum = 0;
		int time = 0;
		for(int i=0;i<N;i++) {
			int curr = Integer.parseInt(st.nextToken());
			if(weightsum+curr<=L) {
				weightsum+=curr;
				time++;
				onBridge.add(new int[] {time+W, curr});
			}else {
				while(true) {
					int[] temp = onBridge.poll();
					weightsum-=temp[1];
					if(weightsum+curr<=L) {
						weightsum+=curr;
						time=temp[0];
						onBridge.add(new int[] {time+W, curr});
						break;
					}
				}
			}
			while(onBridge.size()>0&&onBridge.peek()[0]<=time) {
				int[] temp = onBridge.poll();
				weightsum-=temp[1];
			}
		}
		System.out.println(time+W);
	}
}
