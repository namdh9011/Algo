package y2021.m04.d03;

import java.util.Arrays;
import java.util.HashMap;

public class Solution3_DevMatching {

	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		System.out.println(Arrays.toString(solution(enroll, referral, seller,amount)));
	}
	public static HashMap<String, Integer> map; 
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        int[] parent = new int[enroll.length+1];
        map = new HashMap<>();
        for(int i=0;i<enroll.length;i++) {
        	map.put(enroll[i],i+1);
        }
        for(int i=1;i<=enroll.length;i++) {
        	if(!referral[i-1].equals("-")) {
        		parent[i]=map.get(referral[i-1]);
        	}
        }
        for(int i=0;i<seller.length;i++) {
        	int curr = map.get(seller[i]);
        	int money = amount[i]*100;
        	while(true) {
        		int par = parent[curr];
        		if(par==0) {
        			answer[curr-1]+=money-(int)(money*0.1);
        			break;
        		}else {
        			int tmoney = (int)(money*0.1);
        			answer[curr-1]+=money-tmoney;
        			money=tmoney;
        			curr=par;
        		}
        	}
        }
        return answer;
    }
}
