package y2020.m12.d07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4
 */

class Main_bj_5676_음주코딩_풀지못함 {
	public static int data[];
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	while(true) {
    		 String input = br.readLine();
    		if(input==null) {
    			break;
    		}
    		st = new StringTokenizer(input);
    		int N = Integer.parseInt(st.nextToken());
    		int K = Integer.parseInt(st.nextToken());
    		data = new int[N];
    		st = new StringTokenizer(br.readLine());
    		for(int i=0;i<N;i++) {
    			data[i]=Integer.parseInt(st.nextToken());
    		}
    		for(int i=0;i<K;i++) {
    			st = new StringTokenizer(br.readLine());
    			String s = solve(N,st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    			sb.append(s);
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb.toString());
	}

	private static String solve(int N, String command, int i, int j) {
		if(command.equals("C")) {
			data[i-1] = j;
			return "";
		}else {
			int temp = 1;
			for(int d=i-1;d<j;d++) {
				if(data[d]<0) {
					temp*=-1;
				}else if(data[d]>0) {
					
				}else {
					temp=0;
					break;
				}
			}
			if(temp==0) {
				return "0";
			}else if(temp>0) {
				return "+";
			}else {
				return "-";
			}
		}
	}
}