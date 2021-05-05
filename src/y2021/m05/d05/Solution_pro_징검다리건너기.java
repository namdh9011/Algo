package y2021.m05.d05;

public class Solution_pro_징검다리건너기 {
	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		System.out.println(solution(stones, k));
	}
	public static int solution(int[] stones, int k) {
        int answer = 0;
        int min = 200000001;
        int max = 0;
        for(int i=0;i<stones.length;i++){
            if(stones[i]<min){
                min=stones[i];
            }
            if(stones[i]>max){
                max=stones[i];
            }
        }
        while(min<=max){
            int mid = (min+max)/2;
            if(check(stones, mid, k)){
                min=mid+1;
            }else{
                answer=mid;
                max=mid-1; 
            }
        }
        return answer;
    }
    public static boolean check(int[] stones, int tar, int k){
        int n = stones.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(stones[i]<=tar){
                count++;
                if(count==k){
                    return false;
                }
            }else{
                count=0;
            }
        }
        return true;
    }
}
