package y2021.m05.d28;

import java.util.HashSet;

public class Solution_Hash_베스트앨범 {
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        int n = phone_book.length;
        for(int i=0;i<n;i++){
            set.add(phone_book[i]);   
        }
        for(int i=0;i<n;i++){
            String word = phone_book[i];
            int m = word.length();
            for(int j=1;j<m;j++){
                String curr = word.substring(0,j);
                if(set.contains(curr)){
                    return false;
                }
            }
        }
        return answer;
    }
}

