package y2021.m05.d07;

import java.util.Arrays;
import java.util.HashSet;

public class Solution_pro_보석쇼핑_효율성X {
	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		System.out.println(Arrays.toString(solution(gems)));
	}
	public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        int n = gems.length;
        for(int i=0;i<n;i++){
            set.add(gems[i]);
        }
        int size = set.size();
        if(size==1){
            answer[0]=1;
            answer[1]=1;
        }else{
            int min = Integer.MAX_VALUE;
            here : for(int i=0;i<n;i++){
                set.clear();
                set.add(gems[i]);
                int count=1;
                for(int j=i;j<n;j++){
                    if(!set.contains(gems[j])){
                        count++;
                        set.add(gems[j]);
                        if(count==size){
                            if(j-i<min){
                                min=j-i;
                                answer[0]=i+1;
                                answer[1]=j+1;
                            }
                            continue here;
                        }
                    }
                }
                break;
            }
        }
        return answer;
    }
}
