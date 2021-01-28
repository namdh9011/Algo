package y2020.m10.d23;
import java.io.*;
import java.util.*;
/*
풀이시간 : 30분
시간 : 108ms
메모리 : 14072KB
- 
*/
/*
3
1 0
5
4 2
1 2 3 4
6 0
1 1 9 1 1 1
 */
public class Main_bj_1966_프린터큐 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] pri = new int[10];
			Queue<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int index=0;
			for(int i=0;i<N;i++) {
				int temp = Integer.parseInt(st.nextToken());
				pri[temp]++;
				if(temp>index) {
					index=temp;
				}
				if(M==i) {
					q.add(new int[] {temp, 1});
				}else {
					q.add(new int[] {temp, 0});
				}
			}
			int count=1;
			while(!q.isEmpty()) {
				int[] curr = q.poll();
				if(curr[0]==index) {
					if(curr[1]==1) {
						System.out.println(count);
						break;
					}else {
						count++;
						pri[index]--;
						if(pri[index]==0) {
							for(int i=index-1;i>0;i--) {
								if(pri[i]!=0) {
									index=i;
									break;
								}
							}
						}
					}
				}else {
					q.add(new int[] {curr[0],curr[1]});
				}
			}
		}
	}
}
