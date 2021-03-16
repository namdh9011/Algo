package y2021.m03.d17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Study_프로그래머스대비_정렬 {
	static class Par implements Comparable<Par> {
		int num;
		String name;
		int score;
		public Par(){}
		public Par(int num, String name, int score){
			this.num = num;
			this.name = name;
			this.score = score;
		}
		public String toString() {
			return "[" + this.num + " " + this.name + " " + this.score + "]";
		}
		public int compareTo(Par p) {
			if(this.num>p.num) {
				return 1;
			}else if(this.num==p.num) {
				return this.name.compareTo(p.name);
			}
			return -1;
		}
	}
	public static void main(String[] args) {
		//클래스 정렬
		//1차원 배열 정렬
		//int, String 정렬
		Par[] p = new Par[3];
		ArrayList<Par> al = new ArrayList<>();
		Par p1 = new Par(2, "elice", 70);
		Par p2 = new Par(3, "jisu", 80);
		Par p3 = new Par(2, "adam", 90);
		p[0] = p1;
		p[1] = p2;
		p[2] = p3;
		al.add(p1);
		al.add(p2);
		al.add(p3);
		System.out.println(Arrays.toString(p));
		Arrays.sort(p);
		System.out.println(Arrays.toString(p));
		System.out.println(al);
		Collections.sort(al);
		System.out.println(al);
		Collections.sort(al,new Comparator<Par>() {
			public int compare(Par o1, Par o2) {
				return o2.score - o1.score;
			}
		});
		System.out.println(al);
		System.out.println();
		//2차원 배열 정렬
		//1:내림 0:오름 2:내림
		int[][] test = {{20,90,70},{80,40,50},{60,70,70},{70,90,10},{70,90,15}};
		for(int i=0;i<test.length;i++) {
			System.out.println(Arrays.toString(test[i]));
		}
		Arrays.sort(test, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1]<o2[1]) {
					return 1;
				}else if(o1[1]==o2[1]) {
					if(o1[0]>o2[0]) {
						return 1;
					}else if(o1[0]==o2[0]) {
						return o2[2]-o1[1];
					}
				}
				return -1;
			}
		});
		System.out.println();
		for(int i=0;i<test.length;i++) {
			System.out.println(Arrays.toString(test[i]));
		}
	}
}
