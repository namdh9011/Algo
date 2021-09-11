package y2021.m09.d11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class Solution_pro_카카오3 {
	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		System.out.println(Arrays.toString(solution(fees,records)));
	}
	
	public static int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> in_time = new HashMap<>();
        HashMap<String, Integer> sum_time = new HashMap<>();
        int len = records.length;
        for(int i=0;i<len;i++) {
        	String[] curr = records[i].split(" ");
        	String[] time = curr[0].split(":");
        	int ctime = changeTime(time);
        	if(curr[2].equals("IN")) {
        		in_time.put(curr[1], ctime);
        	}else {
        		if(sum_time.get(curr[1])==null) {
        			sum_time.put(curr[1], ctime-in_time.get(curr[1]));
        		}else {
        			sum_time.put(curr[1], sum_time.get(curr[1])+ctime-in_time.get(curr[1]));
        		}
        		in_time.remove(curr[1]);
        	}
        }
        
        if(in_time.size()>0) {
        	String[] time = {"23","59"};
        	int ctime = changeTime(time);
        	
        	Set<String> keyset = in_time.keySet();
        	for(String key: keyset) {
        		if(sum_time.get(key)==null) {
        			sum_time.put(key, ctime-in_time.get(key));
        		}else {
        			sum_time.put(key, sum_time.get(key)+ctime-in_time.get(key));
        		}
        	}
        }
        
        int[][] temp = new int[sum_time.size()][2];
        int index = 0;
        
        Set<String> keyset = sum_time.keySet();
        for(String key: keyset) {
    		temp[index][0] = Integer.parseInt(key);
    		temp[index][1] = sum_time.get(key);
    		index++;
    	}
        
        Arrays.sort(temp, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
        });
        
        int templen = temp.length;
        int[] answer = new int[templen];
        for(int i=0;i<templen;i++) {
        	answer[i]=calCharge(fees, temp[i][1]);
        }
        return answer;
    }

	private static int calCharge(int[] fees, int time) {
		if(time<=fees[0]) {
			return fees[1];
		}
		time-=fees[0];
		return fees[1] + (int)Math.ceil((double)time/fees[2])*fees[3];
	}

	private static int changeTime(String[] time) {
		int hour = Integer.parseInt(time[0]);
		int min = Integer.parseInt(time[1]);
		return hour*60 + min;
	}
}
