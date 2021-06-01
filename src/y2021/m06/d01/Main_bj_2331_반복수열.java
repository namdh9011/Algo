package y2021.m06.d01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
메모리 : 11536 KB
시간 : 76 ms

최적 메모리 : 12920 KB
최적 시간 : 68 ms
*/
/*
57 2
 */
public class Main_bj_2331_반복수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		ArrayList<Integer> al = new ArrayList<>();
		al.add(A);
		int index = 0;
		here:while(true) {
			int temp = 0;
			int curr = al.get(index);
			while(curr>0) {
				temp+=Math.pow(curr%10,P);
				curr/=10;
			}
			index++;
			System.out.println(temp);
			if (al.contains(temp)) {
				System.out.println(al.indexOf(temp));
				break here;
			}
			al.add(temp);
		}
	}
}


