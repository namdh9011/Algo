package y2021.m02.d22;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
7
abba
summuus
xabba
xabbay
comcom
comwwmoc
comwwtmoc
 */

class Main_bj_17609_회문_틀림 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			String input = br.readLine();
			int start = 0;
			int end = input.length()-1;
			boolean esc = false;
			boolean flag = false;
			while(start<end) {
				if(input.charAt(start)==input.charAt(end)) {
					start++;
					end--;
				}else {
					if(!esc) {
						if(input.charAt(start+1)==input.charAt(end)) {
							if(input.charAt(start+2)==input.charAt(end-1)) {
								start+=3;
								end-=2;
								esc=true;
								continue;
							}
						}
						if(input.charAt(start)==input.charAt(end-1)) {
							if(input.charAt(start+1)==input.charAt(end-2)) {
								start+=2;
								end-=3;
								esc=true;
								continue;
							}
						}
					}else {
						flag=true;
						break;
					}
				}
			}
			if(flag) {
				sb.append(2).append("\n");
			}else {
				if(esc) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}