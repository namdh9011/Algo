package y2020.m12.d16;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_test {
    public static void main(String[] args) throws Exception {
    	
    	int K = 3;
    	String[] user_scores = {"alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200"};
    	System.out.println(solution(K,user_scores));
    }
    public static Queue<String> temp;
    public static int solution(int K, String[] user_scores) {
        int answer = K;
        PriorityQueue<User> pq = new PriorityQueue<>();
        temp = new LinkedList<String>();
        HashMap<String,Integer> map = new HashMap<>();
        int tt = K;
        for(int i=0;i<tt;i++) {
        	StringTokenizer st = new StringTokenizer(user_scores[i]);
        	String name = st.nextToken();
        	int score = Integer.parseInt(st.nextToken());
        	if(map.get(name)==null) {
        		map.put(name, 1);
        		temp.add(name);
        		User u = new User(name, score);
        		pq.add(u);
        	}else {
        		int sii = pq.size();
        		for(int j=0;j<sii;j++) {
        			User tar = pq.poll();
        		}
        		tt++;
        	}
        }
        for(int i=tt;i<user_scores.length;i++) {
        	StringTokenizer st = new StringTokenizer(user_scores[i]);
        	User u = new User(st.nextToken(), Integer.parseInt(st.nextToken()));
        	User tar = pq.poll();
        	if(tar.score<u.score) {
        		if(map.get(u.name)==null){
        			map.remove(tar.name);
        			map.put(u.name, 1);
        			answer++;
        			pq.add(u);		
        		}else {
    				int si = pq.size();
    				for(int j=0;j<si;j++) {
    					User temp = pq.poll();
    					if(temp.name.equals(u.name)) {
    						if(temp.score<u.score) {
    							pq.add(u);
    						}else {
    							pq.add(temp);
    						}
    						break;
    					}else {
    						pq.add(temp);
    					}
    				}
    				if(tar.name.equals(u.name)) {
    					if(u.score>tar.score) {
    						pq.add(u);
    					}
    				}else {
    					pq.add(tar);
    				}
    				boolean f = false;
    				for(int j=0;j<K;j++) {
    					String t = temp.poll();
    					User tu = pq.poll();
    					if(!t.equals(tu.name)) {
    						f=true;
    					}
    					temp.add(tu.name);
    					pq.add(tu);
    				}
    				if(f) {
    					answer++;
    				}
        		}
        	}else {
        		pq.add(tar);
        	}
        	System.out.println(answer);
        	System.out.println(pq);
        	System.out.println(map);
        }
        return answer;
    }
    public static class User implements Comparable<User>{
    	String name;
    	int score;
		public User(String name, int score) {
			this.name = name;
			this.score = score;
		}
		@Override
		public int compareTo(User o) {
			return this.score-o.score;
		}
		@Override
		public String toString() {
			return "User [name=" + name + ", score=" + score + "]";
		}
		
    }
}
