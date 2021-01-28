package y2020.m09.d05;

import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/
public class Solution_pro_깊이너비우선탐색_여행경로 {
	public static void main(String[] args) throws Exception {
		String[][] tickets = {{"ICN","JFK"},{"HND","IAD"},{"JFK","HND"}};
//		String[][] tickets = {{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}};
		System.out.println(Arrays.toString(solution(tickets)));
	}
	
	public static String[] solution(String[][] tickets) {
		int N = tickets.length;
        String[] answer = new String[N+1];
        String result = "ICN";
        String big="";
        boolean[] visit = new boolean[N];
        big = dfs(0,N,"ICN",tickets,result,visit,big);
        for(int i=0;i<N+1;i++) {
        	String temp = "";
        	for(int j=0;j<3;j++) {
        		temp+=big.charAt(i*3+j);
        	}
        	answer[i]=temp;
        }
        return answer;
    }
	private static String dfs(int count, int N, String start, String[][] tickets, String result, boolean[] visit,String big) {
		if(count==N) {
			if(big.equals("")||big.compareTo(result)>0) {
				big=result;
				return big;
			}
		}
		for(int i=0;i<N;i++) {
			if(!visit[i]&&tickets[i][0].equals(start)) {
				visit[i]=true;
				big = dfs(count+1, N, tickets[i][1], tickets, result+tickets[i][1], visit,big);
				visit[i]=false;
			}
		}
		return big;
	}
}
