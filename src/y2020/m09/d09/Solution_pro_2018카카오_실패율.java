package y2020.m09.d09;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_2018카카오_실패율 {
	public static void main(String[] args) throws Exception {
		int N = 4;
		int[] stages = {4,4,4,4,4};
		System.out.println(Arrays.toString(solution(N,stages)));
	}
	
	public static int[] solution(int N, int[] stages) {
		class Player implements Comparable<Player>{
			int num;
			double failrate;
			public Player(int num, double failrate) {
				this.num = num;
				this.failrate = failrate;
			}
			@Override
			public String toString() {
				return "Player [num=" + num + ", failrate=" + failrate + "]";
			}
			@Override
			public int compareTo(Player o) {
				if(this.failrate-o.failrate>0) {
					return -1;
				}else if(this.failrate-o.failrate<0){
					return 1;
				}else {
					return this.num-o.num;
				}
			}
		}
        int[] answer = {};
        PriorityQueue<Player> fail = new PriorityQueue<>();
        boolean[] visit = new boolean[N+1];
        int total = stages.length;
        int curr = 0;
        int count = 0;
        Arrays.sort(stages);
        curr=stages[0];
        for(int i=0;i<stages.length;i++) {
        	if(curr!=stages[i]) {
        		fail.add(new Player(curr, (double)count/total));
        		visit[curr]=true;
        		total=total-count;
        		curr=stages[i];
        		count=1;
        	}else {
        		count++;
        	}
        }
        if(curr!=N+1) {
        	fail.add(new Player(curr, (double)count/total));
        	visit[curr]=true;
        }
        for(int i=1;i<N+1;i++) {
        	if(!visit[i]) {
        		fail.add(new Player(i,0));
        	}
        }
        answer = new int[N];
        int index=0;
        while(!fail.isEmpty()) {
        	answer[index]=fail.poll().num;
        	index++;
        }
        return answer;
    }
}
