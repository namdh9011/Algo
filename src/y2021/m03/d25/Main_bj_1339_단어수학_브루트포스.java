package y2021.m03.d25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
2
ABC
DBEFZ
 */
public class Main_bj_1339_단어수학_브루트포스 {
	public static int a[], max;
	public static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		char[] alph = new char[26];
		char index = 'A';
		for(int i=0;i<N;i++) {
			char[] word = br.readLine().toCharArray();
			for(int j=0;j<word.length;j++) {
				int tran = word[j]-'A';
				if(alph[tran]==0) {
					alph[tran]=index;
					word[j]=index;
					index++;
				}else {
					word[j]=alph[tran];
				}
			}
			words[i]=new String(word);
		}
		v = new boolean[10];
		a = new int[index-'A'];
		comb(words,index-'A',0);
		System.out.println(max);
	}

	private static void comb(String[] words, int K, int count) {
		if(K==count) {
			int num = solve(words, a);
			if(num>max) {
				max=num;
			}
			return;
		}
		for(int i=9;i>=10-K;i--) {
			if(!v[i]) {
				v[i]=true;
				a[count]=i;
				comb(words, K,count+1);
				v[i]=false;
			}
		}
	}

	private static int solve(String[] words, int[] arr) {
		int answer = 0;
		for(int i=0;i<words.length;i++) {
			int n=1;
			for(int j=words[i].length()-1;j>=0;j--) {
				answer+=n*a[words[i].charAt(j)-'A'];
				n*=10;
			}
		}
		return answer;
	}
}
