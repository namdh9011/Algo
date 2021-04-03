package y2021.m04.d03;

public class Solution1_Kakao {

	public static void main(String[] args) {
//		int[] gift_cards = {4,5,3,2,1};
//		int[] wants = {2,4,4,5,1};
		int[] gift_cards = {5,4,5,4,5};
		int[] wants = {1,2,3,5,4};
		System.out.println(solution(gift_cards, wants));
	}

	public static int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        int[] gift_count = new int[100001];
        int n = gift_cards.length;
        for(int i=0;i<n;i++) {
        	gift_count[gift_cards[i]]++;				//상품 개수 카운트
        }
        int m = wants.length;
        for(int i=0;i<m;i++) {
        	if(gift_count[wants[i]]>0) {				//상품이 있으면 개수 빼주고
        		gift_count[wants[i]]--;
        	}else {
        		answer++;								//없으면 못받은 사람 추가
        	}
        }
        return answer;
    }
}
