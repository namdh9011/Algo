package y2020.m09.d01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_힙_디스크컨트롤러 {
	public static void main(String[] args) throws Exception {
		int jobs[][] = {{0,3},{1,9},{2,6}};	//9

		System.out.println(solution(jobs));
	}

	public static int solution(int[][] jobs) {
        class Job implements Comparable<Job>{
        	int start;
        	int time;
			@Override
			public String toString() {
				return "Job [start=" + start + ", time=" + time + "]";
			}
			public Job(int start, int time) {
				this.start = start;
				this.time = time;
			}
			@Override
			public int compareTo(Job o) {
				return this.time-o.time;
			}
        }
        
		int answer = 0;
		int sum = 0;
		int count = jobs.length;
        int time=0;
        Queue<Job> q = new LinkedList<>();
        Arrays.sort(jobs, (o1,o2) -> o1[0]-o2[0]);		//정렬기억!!
        for(int i=0;i<jobs.length;i++) {
        	q.add(new Job(jobs[i][0], jobs[i][1]));
        }
        PriorityQueue<Job> pq = new PriorityQueue<>();
        while(!(q.isEmpty()&&pq.isEmpty())) {
        	int a = q.size();
        	for(int i=0;i<a;i++) {
        		Job temp = q.peek();
        		if(temp.start<=time) {
        			pq.add(q.poll());
        		}else {
        			break;
        		}
        	}
	        if(pq.size()>0) {
	        	Job j = pq.poll();
	        	time+=j.time;
	        	sum=sum+time-j.start;
	        }else {
	        	time++;
	        }
        }
        answer = sum/count;
        return answer;
    }
}
