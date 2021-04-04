package y2021.m04.d04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
- 틀림 다시풀기
*/
/*
9999
 */
public class Main_bj_1475_방번호_틀림 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		boolean[] visit = new boolean[10];
		int count=1;
		for(int i=0;i<s.length();i++) {
			int num = s.charAt(i)-'0';
			if(num==6||num==9) {
				if(visit[6]&&visit[9]) {
					Arrays.fill(visit, false);
					count++;
					visit[6]=true;
				}else if(visit[6]&&!visit[9]) {
					visit[9]=true;
				}else {
					visit[6]=true;
				}
			}else {
				if(visit[num]) {
					Arrays.fill(visit, false);
					count++;
					visit[num]=true;
				}else {
					visit[num]=true;
				}
			}
		}
		System.out.println(count);
	}
}


