package y2020.m09.d07;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_2018카카오_방금그곡 {
	public static void main(String[] args) throws Exception {
		String m = "ABC";
		String[] musicinfos = {"12:00,12:14,HELLO,DDDDDDDDDDDABC","13:00,13:05,WORLD,ABCDEF"};
		System.out.println(solution(m,musicinfos));
	}
	
	
	public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int N = musicinfos.length;
        String[][] data = new String[N][];
        for(int i=0;i<N;i++) {
        	data[i]=musicinfos[i].split(",");
        }
        int[][] playtime = new int[N][2];
        for(int i=0;i<N;i++) {
        	for(int j=0;j<2;j++) {
        		String[] temp = data[i][j].split(":");
        		playtime[i][j]=Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
        	}
        }
        String[] play = new String[N];
        int big = -1;
        for(int i=0;i<N;i++) {
        	play[i]="";
        	int realtime = playtime[i][1]-playtime[i][0];
        	for(int j=0;j<realtime;j++) {
        		char sound = data[i][3].charAt(j%data[i][3].length());
        		if(sound!='#') {
        			play[i]+=sound;
        			if(data[i][3].charAt((j+1)%data[i][3].length())=='#') {
        				play[i]+='#';
        				realtime++;
        			}
        		}
        	}
        	
        	if(play[i].contains(m)) {
        		for(int j=0;j<play[i].length()-m.length()+1;j++) {
        			boolean flag=false;
        			for(int k=0;k<m.length();k++) {
        				if(play[i].charAt(j+k)!=m.charAt(k)) {
        					flag=true;
        					break;
        				}
        			}
        			if(!flag) {
        				if(j+m.length()<play[i].length()&&play[i].charAt(j+m.length())=='#') {
        					continue;
        				}
        				if(big<play[i].length()) {
        					big=play[i].length();
        					answer=data[i][2];
        				}
        			}
           		}
        	}
        }
        return answer;
    }
}
