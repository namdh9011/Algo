package y2021.m05.d06;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_pro_호텔방배정 {
	public static void main(String[] args) {
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		System.out.println(Arrays.toString(solution(k, room_number)));
	}
	public static HashMap<Long, Long> map; 
    public static long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];
        map = new HashMap<>();
        for(int i=0;i<n;i++){
            long temp = findChild(room_number[i]);
            answer[i]=temp;
        }
        return answer;
    }
    
    public static long findChild(long tar){
        if(map.get(tar)==null){
            map.put(tar, tar+1);
            return tar;
        }
        long change = findChild(map.get(tar));
        map.put(tar, change);
        return change;
    }
}
