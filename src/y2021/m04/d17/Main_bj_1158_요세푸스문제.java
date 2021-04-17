package y2021.m04.d17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
메모리 : 12252KB
시간 : 108ms

최적 메모리 : 13660KB
최적 시간 : 86ms
*/
/*
7 3
 */
public class Main_bj_1158_요세푸스문제 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			al.add(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int index = 0;
		int size = N;
		for(int i=0;i<N-1;i++) {
			int curr = (index+K-1)%size;
			sb.append(al.get(curr)).append(", ");
			al.remove(curr);
			size--;
			index=curr;
		}
		sb.append(al.get(0)).append(">");;
		System.out.println(sb.toString());
	}
}