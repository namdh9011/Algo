package y2021.m03.d19;

import java.util.*;
import java.io.*;
/*
3
14
2 1 4 3 5 6 2 7 2 100 100 54 54 50
 */
public class Main_bj_1713_후보추천하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] students = new int[101];
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<M;i++) {
			int reco = Integer.parseInt(st.nextToken());
			if(q.size()<N) {
				if(students[reco]==0) {
					q.add(reco);
				}
				students[reco]++;
			}else {
				if(students[reco]==0) {
					int min = 1001;
					int target = 0;
					for(int j=0;j<N;j++) {
						int curr = q.poll();
						if(students[curr]<min) {
							min=students[curr];
							target=curr;
						}
						q.add(curr);
					}
					for(int j=0;j<N;j++) {
						int curr=q.poll();
						if(curr!=target) {
							q.add(curr);
						}
					}
					q.add(reco);
					students[reco]++;
					students[target]=0;
				}else {
					students[reco]++;
				}
			}
		}
		int t = q.size();
		int[] answer = new int[t];
		for(int i=0;i<t;i++) {
			answer[i] = q.poll();
		}
		Arrays.sort(answer);
		for(int i=0;i<t;i++) {
			System.out.print(answer[i] + " ");
		}
	}
}
