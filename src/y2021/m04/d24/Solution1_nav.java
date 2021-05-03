package y2021.m04.d24;

public class Solution1_nav {
	public static void main(String[] args) {
		int lottos[] = {44,1,0,0,31,25};
		int win_nums[] = {31,10,45,1,6,19};
		System.out.println(solution(lottos,win_nums));
	}

	private static int[] solution(int[] lottos, int[] win_nums) {
		int max = 0;
        int min = 0;
        boolean[] win = new boolean[47];
        for(int i=0;i<win_nums.length;i++){
            win[win_nums[i]]=true;
        }
        for(int i=0;i<lottos.length;i++){
            int tar = lottos[i];
            if(tar==0){
                max++;
            }else{
                if(win[tar]){
                    min++;
                }
            }
        }
        max+=min;
        int[] map = {6,6,5,4,3,2,1};
        int[] answer = new int[2];
        answer[0]=map[max];
        answer[1]=map[min];
        return answer;
	}
}
