package y2020.m09.d12;

import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_카카오코테_5 {
	public static void main(String[] args) throws Exception {
		String play_time = "50:00:00";
		String adv_time = "50:00:00";
		String[] logs = {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"};
		System.out.println(solution(play_time,adv_time,logs));
	}
	
	public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        String[] temp = play_time.split(":");
        int[] play = new int[2];
        int[] adv = new int[2];
        int[][] log = new int[logs.length][2];
        play[0]=0;
        play[1]=Integer.parseInt(temp[0])*60*60 + Integer.parseInt(temp[1])*60 + Integer.parseInt(temp[2]);
        temp = adv_time.split(":");
        adv[0]=0;
        adv[1]=Integer.parseInt(temp[0])*60*60 + Integer.parseInt(temp[1])*60 + Integer.parseInt(temp[2]);
       
        for(int i=0;i<logs.length;i++) {
        	String[] temp1 = logs[i].split("-");
        	temp = temp1[0].split(":");
        	log[i][0]=Integer.parseInt(temp[0])*60*60 + Integer.parseInt(temp[1])*60 + Integer.parseInt(temp[2]);
        	temp = temp1[1].split(":");
        	log[i][1]=Integer.parseInt(temp[0])*60*60 + Integer.parseInt(temp[1])*60 + Integer.parseInt(temp[2]);
        	if(log[i][1]>play[1]) {
        		log[i][1]=play[1];
        	}
        }
        
        Arrays.sort(log,(o1,o2)->o1[0]-o2[0]);
        int max = 0;
        int anstime = 0;
        int a = 0;
        
        int start = 0;
        int end = adv[1];
        for(int j=0;j<log.length;j++) {
        	if(log[j][0]<start&&log[j][1]>=start&&log[j][1]<end) {
        		a+=log[j][1]-start;
        	}else if(log[j][0]>=start&&log[j][1]<end) {
        		a+=log[j][1]-log[j][0];
        	}else if(log[j][0]>=start&&log[j][0]<end&&log[j][1]>=end) {
        		a+=end-log[j][0];
        	}else if(log[j][0]<start&&log[j][1]>=end) {
        		a+=end-start;
        	}
        }
        if(a>max) {
        	max=a;
        	anstime=start;
        }
        
        for(int i=0;i<log.length;i++) {
        	start = log[i][0];
        	end = log[i][0]+adv[1];
        	a=0;
        	for(int j=0;j<log.length;j++) {
        		if(log[j][0]<=start&&log[j][1]>=start&&log[j][1]<=end) {
        			a+=log[j][1]-start;
        		}else if(log[j][0]>=start&&log[j][1]<=end) {
        			a+=log[j][1]-log[j][0];
        		}else if(log[j][0]>=start&&log[j][0]<=end&&log[j][1]>=end) {
        			a+=end-log[j][0];
        		}else if(log[j][0]<start&&log[j][1]>end) {
        			a+=end-start;
        		}
        	}
        	if(a>max) {
        		max=a;
        		anstime=start;
        	}
        }
        
        int h = anstime/3600;
        int m = (anstime%3600)/60;
        int s = anstime%60;
        String hour = "";
        String min = "";
        String sec = "";
        if(h>9) {
        	hour=""+h;
        }else {
        	hour="0"+h;
        }
        if(m>9) {
        	min=""+m;
        }else {
        	min="0"+m;
        }
        if(s>9) {
        	sec=""+s;
        }else {
        	sec="0"+s;
        }
        answer = hour +":"+ min+":" + sec;
        
        return answer;
    }
}
