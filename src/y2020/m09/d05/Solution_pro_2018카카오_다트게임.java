package y2020.m09.d05;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/
public class Solution_pro_2018카카오_다트게임 {
	public static void main(String[] args) throws Exception {
		String dartResult = "1D2S0T";
		System.out.println(solution(dartResult));
	}
	
	public static int solution(String dartResult) {
        int answer = 0;
        int n = dartResult.length();
        int t = 0;
        int[] scoreBoard = new int[3];
        for(int i=0;i<n;i++) {
        	if(dartResult.charAt(i)=='S'||dartResult.charAt(i)=='D'||dartResult.charAt(i)=='T') {
        		if(i==n-1) {
        			if(dartResult.charAt(i-1)=='0'&&i>1&&dartResult.charAt(i-2)=='1') {
        				scoreBoard=scorePlus(scoreBoard,t,"10",dartResult.charAt(i),'0');
        			}else {
        				scoreBoard=scorePlus(scoreBoard,t,dartResult.substring(i-1,i),dartResult.charAt(i),'0');
        			}
        		}else {
        			if(dartResult.charAt(i-1)=='0'&&i>1&&dartResult.charAt(i-2)=='1') {
        				scoreBoard=scorePlus(scoreBoard,t,"10",dartResult.charAt(i),dartResult.charAt(i+1));
        			}else {
        				scoreBoard=scorePlus(scoreBoard,t,dartResult.substring(i-1,i),dartResult.charAt(i),dartResult.charAt(i+1));
        			}
        		}
        		t++;
        	}
        }
        for(int i=0;i<3;i++) {
        	answer+=scoreBoard[i];
        }
        return answer;
    }
	private static int[] scorePlus(int[] scoreBoard, int num, String score, char up, char bonus) {
		int nscore = Integer.parseInt(score);
		if(up=='S') {
			scoreBoard[num]=nscore;
		}else if(up=='D') {
			scoreBoard[num]=nscore*nscore;
		}else if(up=='T') {
			scoreBoard[num]=nscore*nscore*nscore;
		}
		if(bonus=='*') {
			if(num>0) {
				scoreBoard[num-1]=scoreBoard[num-1]*2;
				scoreBoard[num]=scoreBoard[num]*2;
			}else {
				scoreBoard[num]=scoreBoard[num]*2;
			}
		}else if(bonus=='#') {
			scoreBoard[num]=scoreBoard[num]*(-1);
		}
		return scoreBoard;
	}
}
