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

public class Solution_pro_힙_이중우선순위큐 {
	public static void main(String[] args) throws Exception {
//		String operations[] = {"I 16", "D 1"};
//		String operations[] = {"I 7", "I 5", "I -5", "D -1"};
		String operations[] = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

		System.out.println(Arrays.toString(solution(operations)));
	}

	public static PriorityQueue<Integer> first = new PriorityQueue<>();
	public static PriorityQueue<Integer> last = new PriorityQueue<>((o1,o2)->o2-o1);
	public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        for(int i=0;i<operations.length;i++) {
        	String s = operations[i];
        	String[] commend = s.split(" ");
        	if(commend[0].equals("I")) {
        		first.add(Integer.parseInt(commend[1]));
        		last.add(Integer.parseInt(commend[1]));
        	}else if(commend[0].equals("D")&&!first.isEmpty()) {
        		delete(Integer.parseInt(commend[1]));
        	}
        }
        if(first.peek()!=null) {
        	answer[1] = first.poll();
        }else {
        	answer[1] = 0;
        }
        if(last.peek()!=null) {
        	answer[0] = last.poll();
        }else {
        	answer[0] = 0;
        }
        return answer;
    }

	private static void delete(int num) {
		if(num==1) {
			int a = last.poll();
			Queue<Integer> q = new LinkedList<>();
			while(!first.isEmpty()) {
				int b = first.poll();
				if(a==b) {
					break;
				}else {
					q.add(b);
				}
			}
			while(!q.isEmpty()) {
				first.add(q.poll());
			}
		}else {
			int a = first.poll();
			Queue<Integer> q = new LinkedList<>();
			while(!last.isEmpty()) {
				int b = last.poll();
				if(a==b) {
					break;
				}else {
					q.add(b);
				}
			}
			while(!q.isEmpty()) {
				last.add(q.poll());
			}
		}
	}
}
