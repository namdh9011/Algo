package y2021.m04.d10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
/*
메모리 : 23744KB
시간 : 696ms

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
		N=set.size();
		String[] words = new String[N];
		Iterator<String> iter = set.iterator();
		for(int i=0;i<N;i++) {
			words[i]=iter.next();
		}
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length()==s2.length()) {
					return s1.compareTo(s2);
				}
				return s1.length()-s2.length();
			}
		});
		for(int i=0;i<N;i++) {
			System.out.println(words[i]);
		}
	}
}