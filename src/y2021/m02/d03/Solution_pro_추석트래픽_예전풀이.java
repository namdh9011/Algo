package y2021.m02.d03;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_추석트래픽_예전풀이 {
	public static void main(String[] args) throws Exception {
		String lines[] =  {"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s"};
//		String lines[] = {"2016-09-15 03:10:33.020 0.011s"};
		
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
