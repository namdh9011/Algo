package y2021.m03.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
/*
2
ABC
DBEFZ
 */
public class Main_bj_1339_단어수학_틀림 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] map = new String[10][2];
		String[] words = new String[N];
		for(int i=0;i<map.length;i++) {
			map[i][0]="";
			int c = 'A'+i;
			map[i][1]=(char)c+"";
		}
		HashMap<Character, Character> hash = new HashMap<>();
		boolean[] f = new boolean[26];
		int index=0;
		for(int i=0;i<N;i++) {
			String word = br.readLine();
			char[] ct = word.toCharArray();
			for(int j=0;j<ct.length;j++) {
				if(!f[ct[j]-'A']) {
					f[ct[j]-'A']=true;
					int tt = ct[j]-'A';
					int ttt = index+'A';
					hash.put((char)tt,(char)ttt);
					ct[j]=(char)ttt;
					index++;
				}else {
					int tt = ct[j]-'A';
					ct[j]=hash.get((char)tt);
				}
			}
			word = new String(ct);
			words[i]=word;
			int len = word.length();
			for(int j=len-1;j>=0;j--) {
				int temp = 'A'+j;
				String curr = (char)temp + "";
				map[word.charAt(len-j-1)-'A'][0]=map[word.charAt(len-j-1)-'A'][0]+curr;
			}
		}
		for(int i=0;i<map.length;i++) {
			char[] temp = map[i][0].toCharArray();
			Arrays.sort(temp);
			String nword = "";
			for(int j=temp.length-1;j>=0;j--) {
				nword+=temp[j];
			}
			map[i][0]=nword;
		}
		Arrays.sort(map,new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				return -s1[0].compareTo(s2[0]);
			}
		});
		int[] dict = new int[10];
		for(int i=0;i<map.length;i++) {
			char t = map[i][1].charAt(0);
			dict[t-'A'] = 9-i;
		}
		int answer = 0;
		for(int i=0;i<N;i++) {
			String temp = "";
			for(int j=0;j<words[i].length();j++) {
				temp+=dict[words[i].charAt(j)-'A'];
			}
			answer+=Integer.parseInt(temp);
		}
		System.out.println(answer);
	}
}
