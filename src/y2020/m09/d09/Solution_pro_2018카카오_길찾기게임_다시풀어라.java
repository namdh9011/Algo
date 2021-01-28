package y2020.m09.d09;

import java.util.Arrays;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
- 

*/

public class Solution_pro_2018카카오_길찾기게임_다시풀어라 {
	public static void main(String[] args) throws Exception {
		int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		System.out.println(Arrays.deepToString(solution(nodeinfo)));
	}
	
	public static int map[][], answer[][],indexa,indexb;
	public static int[][] solution(int[][] nodeinfo) {
        int N = nodeinfo.length;
        answer = new int[2][N];
        indexa=0;
        indexb=0;
        int bigx=0;	//13
        int bigy=0;	//6
        int startx=0;
        int starty=0;
        for(int i=0;i<N;i++) {
        	if(nodeinfo[i][0]>bigx) {
        		bigx=nodeinfo[i][0];
        	}
        	if(nodeinfo[i][1]>bigy) {
        		bigy=nodeinfo[i][1];
        	}
        }
        map = new int[bigy+1][bigx+1];
//        for(int i=0;i<map.length;i++) {
//        	System.out.println(Arrays.toString(map[i]));
//        }
        for(int i=0;i<N;i++) {
        	map[bigy-nodeinfo[i][1]][nodeinfo[i][0]]=i+1;
        }
        for(int i=0;i<bigx;i++) {
        	if(map[0][i]!=0) {
        		starty=i;
        	}
        }
        answer[0][indexa]=map[startx][starty];
        indexa++;
        ordera(1,0,bigy,starty-1);
        orderb(1,starty+1,bigy,bigx);
        answer[1][indexb]=map[startx][starty];
        indexb++;
        return answer;
    }
	private static void orderb(int startx, int starty, int endx, int endy) {
		for(int i=startx;i<=endx;i++) {
			for(int j=starty;j<=endy;j++) {
				if(map[i][j]!=0) {
					answer[0][indexa]=map[i][j];
					indexa++;
					ordera(i+1,starty,endx,j-1);
					orderb(i+1,j+1,endx,endy);
					answer[1][indexb]=map[i][j];
					indexb++;
					return;
				}
			}
		}
	}
	private static void ordera(int startx, int starty, int endx, int endy) {
		for(int i=startx;i<=endx;i++) {
			for(int j=endy;j>=starty;j--) {
				if(map[i][j]!=0) {
					answer[0][indexa]=map[i][j];
					indexa++;
					ordera(i+1,starty,endx,j-1);
					orderb(i+1,j+1,endx,endy);
					answer[1][indexb]=map[i][j];
					indexb++;
					return;
				}
			}
		}
	}
}
