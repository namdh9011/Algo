package y2021.m04.d18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
- 시간초과
*/
/*
abcd
3
P x
L
P y
 */
public class Main_bj_1406_에디터_시간초과 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		ArrayList<Character> al = new ArrayList<>();
		for(int i=0;i<s.length();i++) {
			al.add(s.charAt(i));
		}
		int N = Integer.parseInt(br.readLine());
		int index = al.size();
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			char command = temp.charAt(0);
			if(command=='L') {
				if(index>0) {
					index--;
				}
			}else if(command=='D') {
				if(index<al.size()) {
					index++;
				}
			}else if(command=='B') {
				if(index>0) {
					al.remove(index-1);
					index--;
				}
			}else {
				temp = st.nextToken();
				for(int j=0;j<temp.length();j++) {
					al.add(index, temp.charAt(j));
					index++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<al.size();i++) {
			sb.append(al.get(i));
		}
		System.out.println(sb.toString());
	}
}