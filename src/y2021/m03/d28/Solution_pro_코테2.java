package y2021.m03.d28;
import java.util.HashSet;

public class Solution_pro_코테2 {
	public static void main(String[] args) throws Exception {
		String s = "zxzxz";
		System.out.println(Solution(s));
	}

	private static int Solution(String s) {
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<s.length();i++) {
			boolean[] visit = new boolean[26];
			for(int j=i;j<s.length();j++) {
				if(!visit[s.charAt(j)-'a']) {
					visit[s.charAt(j)-'a']=true;
					set.add(s.substring(i,j+1));
				}else {
					break;
				}
			}
		}
		System.out.println(set);
		int answer = set.size();
		return answer;
	}
}
