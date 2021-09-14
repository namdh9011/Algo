package y2021.m09.d14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/*
메모리 : 11528 KB
시간 : 80 ms

최적 메모리 : 12740 KB
최적 시간 : 68 ms

*/
/*
5 4
3 1
3 2
4 3
5 3
 */
public class Main_bj_10814_나이순정렬 {
	public static class Member implements Comparable<Member> {
		int num;
		int age;
		String name;
		public Member(int num, int age, String name) {
			this.num = num;
			this.age = age;
			this.name  = name;
		}
		public int compareTo(Member o) {
			if(this.age > o.age) {
				return 1;
			}else if(o.age == this.age) {
				return this.age - o.age;
			}
			return -1;
		}
		public String toString() {
			return this.num + " " + this.age + " " + this.name;
		}
	}
	public static void main(String[] args) throws Exception {
		//init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<Member> al = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Member m = new Member(i,age,name);
			al.add(m);
		}
		Collections.sort(al);
		int len = al.size();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<len;i++) {
			sb.append(al.get(i).age).append(" ").append(al.get(i).name).append("\n");
		}
		System.out.println(sb.toString());
	}
}


