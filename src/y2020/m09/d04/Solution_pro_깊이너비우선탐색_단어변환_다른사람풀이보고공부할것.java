package y2020.m09.d04;

import java.util.HashMap;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/
public class Solution_pro_깊이너비우선탐색_단어변환_다른사람풀이보고공부할것 {
	public static void main(String[] args) throws Exception {
//		String begin = "hit";
//		String target = "cog";
//		String[] words = {"hot","dot","dog","lot","log","cog"};
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot","dot","dog","lot","log"};
		System.out.println(solution(begin,target,words));
	}
	public static int answer;
	public static HashMap<String, Boolean> map;
	public static int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        map = new HashMap<>();
        int N = begin.length();
        
        dfs(N,begin,target,words,0);
        if(answer==Integer.MAX_VALUE) {
        	answer = 0;
        }
        return answer;
    }
	private static void dfs(int N, String begin, String target, String[] words, int count) {
		if(begin.equals(target)) {
//			System.out.println(count);
			if(count<answer) {
				answer = count;
			}
			return;
		}
		for(int i=0;i<N;i++) {
			for(int j=97;j<123;j++) {
				String nword = changeWord(begin,i,j);
				if(!nword.equals(begin)) {
					for(int k=0;k<words.length;k++) {
						if(map.get(nword)==null&&nword.equals(words[k])) {
							map.put(nword, true);
//							System.out.println(nword);
							dfs(N,nword,target,words,count+1);
							map.remove(nword);
						}
					}
				}
			}
		}
	}
	private static String changeWord(String begin, int i, int j) {
		char[] temp = new char[begin.length()];
		for(int k=0;k<begin.length();k++) {
			temp[k]=begin.charAt(k);
		}
		temp[i]=(char)j;
		String output = "";
		for(int k=0;k<temp.length;k++) {
			output+=temp[k];
		}
		return output;
	}
}
