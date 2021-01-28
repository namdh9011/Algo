package y2020.m09.d06;

/*
풀이시간 : 
시간 : 
메모리 : 
- 시간 처리 잘봐야됨!!!
- 끝나는 시간부터 앞으로 2.0초인데 반대로봐서 애먹음
- 앞으로 2초이면 04.001 - 2.0 초에 0.0001초를 더해줘야함.
(ex 2.001~4.000 까지가 2초임)

*/
public class Solution_pro_2018카카오_추석트래픽_정리 {
	public static void main(String[] args) throws Exception {
//		String[] lines = {"2016-09-15 20:59:57.421 0.351s",
//				"2016-09-15 20:59:58.233 1.181s",
//				"2016-09-15 20:59:58.299 0.8s",
//				"2016-09-15 20:59:58.688 1.041s",
//				"2016-09-15 20:59:59.591 1.412s",
//				"2016-09-15 21:00:00.464 1.466s",
//				"2016-09-15 21:00:00.741 1.581s",
//				"2016-09-15 21:00:00.748 2.31s",
//				"2016-09-15 21:00:00.966 0.381s",
//				"2016-09-15 21:00:02.066 2.62s"};
		String[] lines = {"2016-09-15 01:00:04.001 2.0s",
				"2016-09-15 01:00:07.000 2s"};
		System.out.println(solution(lines));
	}
	
	
	public static int solution(String[] lines) {
        int answer = 0;
        int N = lines.length;
        String[][] data = new String[N][3];
        for(int i=0;i<N;i++) {
        	data[i]=lines[i].split(" ");
        }
        int[][] time = new int[N][2];
        for(int i=0;i<N;i++) {
        	String[] temp = data[i][1].split(":");
        	temp[2] = temp[2].replace(".", "");
        	time[i][1] = Integer.parseInt(temp[0])*60*60*1000 + Integer.parseInt(temp[1])*60*1000 + Integer.parseInt(temp[2]);
        	String a = data[i][2].replace("s", "").replace(".", "");
    		int t = Integer.parseInt(a);
    		for(int j=0;j<4-a.length();j++) {
    			t*=10;
    		}
    		time[i][0]+=time[i][1]-t+1;
        	//day생각
        }
        for(int i=0;i<N;i++) {
        	int count=0;
        	int startpro = time[i][1];
        	int endpro = time[i][1]+1000;
        	for(int j=0;j<N;j++) {
        		if(time[j][1]>=startpro&&time[j][0]<endpro) {
        			count++;
        		}
        	}
        	if(count>answer) {
        		answer = count;
        	}
        }
        return answer;
    }
}
