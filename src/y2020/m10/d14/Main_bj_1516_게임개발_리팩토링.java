package y2020.m10.d14;

import java.util.*;
import java.io.*;
/*
풀이시간 : 50분
시간 : 212ms
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
public class Main_bj_1516_게임개발_리팩토링 {
	public static int time[],memo[];
	public static ArrayList<Integer> al[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
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
			sb.append(memo[i]).append("\n");
		}
		System.out.println(sb);
	}
	private static int dfs(int num) {
		if(memo[num]!=-1) {		//메모된 시간이 있으면 리턴
			return memo[num];
		}						//먼저 지어야 하는 건물이 없으면 메모하고 리턴
		if(al[num].size()==0) {
			memo[num]=time[num];
			return memo[num];
		}
		int ret = 0;							//최대시간 임시
		for(int i=0;i<al[num].size();i++) {
			int temp = al[num].get(i)-1;		//먼저 지어야하는 건물
			ret = Integer.max(ret,dfs(temp)+time[num]);
		}
		memo[num]=ret;	//dfs 중간에 메모값 갱신 *******이거 안하면 시간초과
		return ret;
	}
}
