package y2021.m05.d29;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_dfs_bfs_여행경로 {
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		System.out.println(Arrays.toString(solution(tickets)));
	}
	public static boolean visit[];
    public static PriorityQueue<String> pq;
    public static String[] solution(String[][] tickets) {
        int n = tickets.length;
        pq = new PriorityQueue<>();
        String[] answer = new String[n+1];
        visit = new boolean[n];
        answer[0]="ICN";
        dfs(n,tickets,"ICN",1,answer);
        String s = pq.poll();
        for(int i=0;i<n+1;i++){
            answer[i]=s.substring(i*3,i*3+3);
        }
        return answer;
    }
    public static void dfs(int n, String[][] tickets, String curr, int count, String[] answer){
        if(count==n+1){          
            String temp = "";
            for(int i=0;i<answer.length;i++){
                temp+=answer[i];
            }
            pq.add(temp);
            return;
        }
        for(int i=0;i<n;i++){
            if(tickets[i][0].equals(curr)&&!visit[i]){
                visit[i]=true;
                answer[count]=tickets[i][1];
                dfs(n,tickets,tickets[i][1],count+1,answer);
                visit[i]=false;
            }
        }
    }
}

