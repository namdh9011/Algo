package y2021.m04.d23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*
메모리 : 25676KB
시간 : 700ms

최적 메모리 : 19820KB
최적 시간 : 216ms
*/
/*
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours
 */
public class Main_bj_1181_단어정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		Iterator<String> ite = set.iterator();
		N = set.size();
		String[] word = new String[N];
		for(int i=0;i<N;i++) {
			word[i]=ite.next();
		}
		Arrays.sort(word, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length()==s2.length()) {
					return s1.compareTo(s2);
				}
				return s1.length()-s2.length();
			}
		});
		for(int i=0;i<N;i++) {
			System.out.println(word[i]);
		}
	}
}