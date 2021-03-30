package y2021.m03.d30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
메모리 : 14056KB
시간 : 120ms

최적 메모리 : 14436KB
최적 시간 : 96ms
*/
/*
4
120 110 140 150
485
 */
public class Main_bj_2512_예산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] request = new int[N];
		int total = 0;
		for(int i=0;i<N;i++) {
			request[i]=Integer.parseInt(st.nextToken());
			total+=request[i];
		}
		Arrays.sort(request);
		int ans = 0;
		int M = Integer.parseInt(br.readLine());
		if(total<=M) {
			ans=request[N-1];
		}else {
			int low = 0;
			int high = request[N-1]+1;
			int mid = 0;
			while(low<=high) {
				mid=(high+low)/2;
				int sum = 0;
				for(int i=0;i<N;i++) {
					if(request[i]<=mid) {
						sum+=request[i];
					}else {
						sum+=mid*(N-i);
						break;
					}
				}
				if(sum>M) {
					high=mid-1;
				}else {
					if(ans<mid) {
						ans=mid;
					}
					low=mid+1;
				}
			}
		}
		System.out.println(ans);
	}
}


