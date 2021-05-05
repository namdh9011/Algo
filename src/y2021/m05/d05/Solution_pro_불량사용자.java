package y2021.m05.d05;

import java.util.Arrays;
import java.util.HashSet;

public class Solution_pro_불량사용자 {
	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "abc1**"};
		System.out.println(solution(user_id, banned_id));
	}
	public static boolean visit[];
    public static HashSet<String> set;
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        set = new HashSet<>();
        int n = user_id.length;
        int k = banned_id.length;
        visit = new boolean[n];
        int[] order = new int[k];
        perm(0, user_id, banned_id, n, k, order);
        answer = set.size();
        return answer;
    }
    public static void perm(int count, String[] user_id, String[] banned_id, int n, int k, int[] order){
        if(count==k){
            if(solve(order, banned_id, user_id, n, k)){
                int[] temp = order.clone();
                Arrays.sort(temp);
                String ord = "";
                for(int i=0;i<k;i++){
                    ord+=temp[i];
                }
                set.add(ord);
            }
            return;
        }
        for(int i=0;i<n;i++){
            
            if(!visit[i]){
                order[count]=i;
                visit[i]=true;
                perm(count+1, user_id, banned_id, n, k, order);
                visit[i]=false;
            }
        }
    }
    public static boolean solve(int[] order, String[] banned_id, String[] user_id, int n, int k){
        for(int i=0;i<k;i++){
            String curr = user_id[order[i]];
            if(!check(curr, banned_id[i])){
                return false;
            }
        }
        return true;
    }
    public static boolean check(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        for(int i=0;i<s1.length();i++){
            if(s2.charAt(i)=='*') continue;
            if(s1.charAt(i)!=s2.charAt(i)) return false;
        }
        return true;
    }
}
