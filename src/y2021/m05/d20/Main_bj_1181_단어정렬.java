package y2021.m05.d20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
/*
메모리 : 30128KB
시간 : 328ms

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
		HashSet<String> set = new HashSet<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		Iterator<String> iter = set.iterator();
		ArrayList<String> al = new ArrayList<>();
		while(iter.hasNext()) {
			al.add(iter.next());
		}
		Collections.sort(al,new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length()==s2.length()) {
					return s1.compareTo(s2);
				}
				return s1.length()-s2.length();
			}
		});
		StringBuilder sb = new StringBuilder();
		int alsize = al.size();
		for(int i=0;i<alsize;i++) {
			sb.append(al.get(i)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
