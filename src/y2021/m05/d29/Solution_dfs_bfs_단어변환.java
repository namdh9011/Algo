package y2021.m05.d29;

import java.util.HashSet;

public class Solution_dfs_bfs_단어변환 {
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin, target,words));
	}
	public static int min;
    public static int solution(String begin, String target, String[] words) {
        min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            set.add(words[i]);
        }
        dfs(begin,target,0,set);
        if(min==Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
    public static void dfs(String begin, String target, int deep,HashSet<String> set){
        if(begin.equals(target)){
            if(min>deep){
                min=deep;
            }
            return;
        }
        int n = begin.length();
        for(int i=0;i<n;i++){
            for(int j='a';j<='z';j++){
                String temp = begin.substring(0,i) + (char)j + begin.substring(i+1,n);
                if(!temp.equals(begin)&&set.contains(temp)){
                    set.remove(temp);
                    dfs(temp, target, deep+1,set);
                    set.add(temp);
                }
            }
        }
    }
}

