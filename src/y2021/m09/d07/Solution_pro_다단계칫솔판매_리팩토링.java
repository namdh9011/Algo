package y2021.m09.d07;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_pro_다단계칫솔판매_리팩토링 {
	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
	}
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        //init
        HashMap<String, String> parents = new HashMap<>();
        HashMap<String, Integer> account = new HashMap<>();
        account.put("-",0);
        for(int i=0;i<enroll.length;i++){
            parents.put(enroll[i], referral[i]);
            account.put(enroll[i],0);
        }
        
        //solve
        for(int i=0;i<seller.length;i++){
            solve(parents, account, seller[i], amount[i]*100);
        }
        
        //output
        for(int i=0;i<enroll.length;i++) {
        	answer[i]=account.get(enroll[i]);
        }
        return answer;
    }
    
    public static void solve(HashMap<String, String> parents, HashMap<String, Integer> account, String seller, int amount){
        if(seller.equals("-")||amount<10){
            account.put(seller, account.get(seller)+amount);
            return;
        }
        int dif = (int)(amount*0.1);
        account.put(seller,account.get(seller)+amount-dif);
        solve(parents, account, parents.get(seller), dif);
    }
}
