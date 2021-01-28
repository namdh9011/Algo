package y2020.m09.d06;

import java.util.PriorityQueue;

/*
풀이시간 : 
시간 : 
메모리 : 
-
-
-

*/
public class Solution_pro_2018카카오_셔틀버스 {
	public static void main(String[] args) throws Exception {
		int n =2;
		int t =10;
		int m =2;
		String[] timetable = {"09:10","09:09","08:00"};
		System.out.println(solution(n,t,m,timetable));
	}
	
	public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] bus = new int[n];
        for(int i=0;i<n;i++) {
        	bus[i] = 540 + i*t;
        }
        
        int p = timetable.length;
        PriorityQueue<Integer> player = new PriorityQueue<>();
        for(int i=0;i<p;i++) {
        	String[] temp = timetable[i].split(":");
        	int ho = Integer.parseInt(temp[0]);
        	int mi = Integer.parseInt(temp[1]);
        	player.add(ho*60+mi);
        }
        int[][] inBus = new int[n][m];
        for(int i=0;i<n;i++) {
        	for(int j=0;j<m;j++) {
        		inBus[i][j]=-1;
        	}
        }
        int b = 0;
        int f = 0;
        while(!player.isEmpty()) {
        	if(b>=n) {
        		break;
        	}
        	int k = player.poll();
        	if(k<=bus[b]) {
        		inBus[b][f] = k;
        		f++;
        		if(f>=m) {
        			b++;
        			f=0;
        		}
        	}else {
        		b++;
        		f=0;
        		player.add(k);
        	}
        }
        
        int lastseat = inBus[n-1][m-1];
        int ho = bus[n-1]/60;
        int mi = bus[n-1]%60;
        
        if(lastseat!=-1) {
        	int big = -1;
        	for(int i=0;i<m;i++) {
        		if(inBus[(n-1)][i]>big) {
        			big = inBus[n-1][i];
        		}
        	}
        	big--;
        	ho = big/60;
        	mi = big%60;
        }
        if(ho<10&&mi<10) {
        	answer = "0" + ho + ":0" + mi;
        }else if(ho>=10&&mi<10){
        	answer = ho + ":0" + mi;
        }else if(ho<10&&mi>=10) {
        	answer = "0" + ho + ":" + mi;
        }else {
        	answer = ho + ":" + mi;
        }
        return answer;
    }
}
