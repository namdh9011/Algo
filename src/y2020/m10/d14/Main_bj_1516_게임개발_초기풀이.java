package y2020.m10.d14;

import java.util.*;
import java.io.*;
/*
풀이시간 : 50분
시간 : 276ms
메모리 : 20880KB
- 메모이제이션 안하면 시간초과 남.
*/
/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
 */
public class Main_bj_1516_게임개발_초기풀이 {
	public static int time[],memo[];
	public static ArrayList<Integer> al[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		time = new int[N];
		memo = new int[N];
		al = new ArrayList[N];
		for(int i=0;i<N;i++) {
			memo[i]=-1;
			al[i]=new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int curr = Integer.parseInt(st.nextToken());
				if(curr==-1) {
					break;
				}
				al[i].add(curr);
			}
		}
		for(int i=0;i<N;i++) {
			memo[i] = dfs(i);
		}
		for(int i=0;i<N;i++) {
			System.out.println(memo[i]);
		}
	}
	private static int dfs(int num) {
		if(memo[num]!=-1) {
			return memo[num];
		}
		if(al[num].size()==0) {
			memo[num]=time[num];
			return memo[num];
		}
		int ret = 0;
		for(int i=0;i<al[num].size();i++) {
			int temp = al[num].get(i)-1;
			if(memo[temp]==-1) {
				ret = Integer.max(ret,dfs(temp)+time[num]);
			}else {
				ret = Integer.max(ret,memo[temp]+time[num]);
			}
		}
		memo[num]=ret;	//이거 안하면 시간초과
		return ret;
	}
}
