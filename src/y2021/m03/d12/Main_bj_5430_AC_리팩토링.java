package y2021.m03.d12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
5
RDD
4
[1,2,3,4]
D
1
[42]
RRD
6
[1,1,2,3,5,8]
D
0
[]
R
1
[1]
 */

class Main_bj_5430_AC_리팩토링 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			String command = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			String[] arr = input.substring(1,input.length()-1).split(",");
			sb.append(solve(command,N,arr)).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static String solve(String command, int N, String[] arr) {
		int rev = 1;
		int head = 0;
		int tail = N;
		for(int i=0;i<command.length();i++) {
			char com = command.charAt(i);
			if(com=='R') {
				rev*=-1;
			}else if(com=='D') {
				if(rev==1) {
					head++;
				}else {
					tail--;
				}
				if(head>tail) {
					return "error";
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if(tail-head>0) {
			if(rev==1) {
				for(int i=head;i<tail-1;i++) {
					sb.append(arr[i]).append(",");
				}
				sb.append(arr[tail-1]);
			}else {
				for(int i=tail-1;i>head;i--) {
					sb.append(arr[i]).append(",");
				}
				sb.append(arr[head]);
			}
		}
		sb.append("]");
		return sb.toString();
	}
}