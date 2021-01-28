package y2020.m09.d29;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_bj_9093_언어뒤집기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			String[] curr = br.readLine().split(" ");
			sb.append(reverseSen(curr)).append("\n");
		}
		System.out.println(sb.toString());
	}									
	
	public static String reverseSen(String[] sentence) {
		String answer = "";
		for(int i=0;i<sentence.length;i++) {
			String s = "";
			for(int j=sentence[i].length()-1;j>=0;j--) {
				s += sentence[i].charAt(j) + "";
			}
			answer += s + " ";
		}
		return answer;
	}
}
