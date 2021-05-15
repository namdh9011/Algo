package y2021.m05.d15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
메모리 : 356896KB
시간 : 1764ms

최적 메모리 : 1128KB
최적 시간 : 82300ms
*/
/*
5
2 4 -10 4 -9
 */
public class Main_bj_18870_좌표압축 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] data = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			data[i]=Integer.parseInt(st.nextToken());
		}
		int[] sortdata = data.clone();
		Arrays.sort(sortdata);
		int curr = Integer.MAX_VALUE;
		int index = 0;
		for(int i=0;i<N;i++) {
			if(curr!=sortdata[i]) {
				map.put(sortdata[i],index);
				curr=sortdata[i];
				index++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(map.get(data[i])).append(" ");
		}
		System.out.println(sb.toString());
	}
}


