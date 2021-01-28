package y2020.m10.d21;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
*/
public class Main_prac_1 {
	public static void main(String[] args) throws Exception{
		int math_scores[] = {70,65,90,80,50};
		int english_scores[] = {40,20,30,60,50};
		
		System.out.println(solution(math_scores, english_scores));
	}
	public static int solution(int[] math_scores, int[] english_scores) {
		int answer = 0;
		for(int i=0;i<math_scores.length;i++) {
			for(int j=0;j<math_scores.length;j++) {
				if(math_scores[i]>math_scores[j]&&english_scores[i]>english_scores[j]) {
					answer++;
				}
			}
		}
		return answer;
	}
}