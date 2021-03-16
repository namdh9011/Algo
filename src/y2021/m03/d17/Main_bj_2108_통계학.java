package y2021.m03.d17;

import java.util.*;
import java.io.*;
/*
5
1
4
8
-2
2
 */
public class Main_bj_2108_통계학 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] visit = new int[8001];
		int sum = 0;
		int max = 0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i];
			int temp = arr[i]+4000;
			visit[temp]++;
			if(max<visit[temp]) {
				max = visit[temp];
			}
		}
		Arrays.sort(arr);
		int counting = 0;
		boolean flag = false;
		for(int i=0;i<=visit.length;i++) {
			if(visit[i]==max) {
				counting=i;
				if(!flag) {
					flag=true;
				}else {
					counting=i;
					break;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(Math.round((double)sum/N)).append("\n");
		sb.append(arr[N/2]).append("\n");
		sb.append(counting-4000).append("\n");
		sb.append(arr[N-1]-arr[0]);
		System.out.println(sb.toString());
	}
}
