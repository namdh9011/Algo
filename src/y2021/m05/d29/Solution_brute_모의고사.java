package y2021.m05.d29;

import java.util.ArrayList;

public class Solution_brute_모의고사 {
	public static void main(String[] args) {
		int[] answer = {1,2,3,4,5};
		System.out.println(solution(answer));
	}
	public static int[] p1={1,2,3,4,5},p2={2,1,2,3,2,4,2,5},p3={3,3,1,1,2,2,4,4,5,5};
    public static int[] solution(int[] answers) {
        int[] count = new int[3];
        int n = answers.length;
        for(int i=0;i<n;i++){
            int curr = answers[i];
            int a = p1.length;
            int b = p2.length;
            int c = p3.length;
            if(p1[i%a]==curr){
                count[0]++;
            }
            if(p2[i%b]==curr){
                count[1]++;
            }
            if(p3[i%c]==curr){
                count[2]++;
            }
        }
        int max = 0;
        for(int i=0;i<3;i++){
            if(count[i]>max){
                max = count[i];
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<3;i++){
            if(max==count[i]){
                al.add(i+1);
            }
        }
        int[] answer = new int[al.size()];
        for(int i=0;i<al.size();i++){
            answer[i]=al.get(i);
        }
        return answer;
    }
}

