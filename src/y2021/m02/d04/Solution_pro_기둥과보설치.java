package y2021.m02.d04;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
풀이시간 : 
시간 : 
메모리 : 
- 
- 
*/

public class Solution_pro_기둥과보설치 {
	public static void main(String[] args) throws Exception {
//		int n = 5;
//		int build_frame[][] = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		int n = 5;
		int build_frame[][] = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		
		System.out.println(Arrays.deepToString(solution(n, build_frame)));
	}
	public static int[][] solution(int n, int[][] build_frame) {
		int[][][] map = new int[n+1][n+1][2];
		for(int i=0;i<build_frame.length;i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int kind = build_frame[i][2];
			int command = build_frame[i][3];
			if(command==1) {
				if(kind==0) {
					if(y==0) {
						map[x][y][kind]=1;
					}else if(y-1>=0&&map[x][y-1][0]==1) {
						map[x][y][kind]=1;
					}else if(x-1>=0&&map[x-1][y][1]==1) {
						map[x][y][kind]=1;
					}
				}else {
					if(y-1>=0&&map[x][y-1][0]==1) {
						map[x][y][kind]=1;
					}else if(x+1<n+1&&y-1>=0&&map[x+1][y-1][0]==1) {
						map[x][y][kind]=1;
					}else if(x-1>=0&&x+1<n+1&&map[x-1][y][1]==1&&map[x+1][y][1]==1) {
						map[x][y][kind]=1;
					}
				}
			}else {
				if(kind==0) {
					if((y+1<n+1&&map[x][y+1][0]==1)||(y+1<n+1&&map[x][y+1][1]==1)||(y+1<n+1&&x-1>=0&&map[x-1][y+1][1]==1)) {
						continue;
					}else {
						map[x][y][kind]=0;
					}
				}else {
					if(map[x][y][0]==1||(x+1<n+1&&map[x+1][y][0]==1)||(x+2<n+1&&map[x+1][y][1]==1&&map[x+2][y][1]==1)||(x-2>=0&&map[x-1][y][1]==1&&map[x-2][y][1]==1)) {
						continue;
					}else {
						map[x][y][kind]=0;
					}
				}
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]>o2[0]) {
					return 1;
				}else if(o1[0]==o2[0]) {
					if(o1[1]>o2[1]) {
						return 1;
					}else if(o1[1]==o2[1]) {
						return o1[2]-o2[2];
					}
				}
				return -1;
			}
		});
		for(int k=0;k<2;k++) {
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map.length;j++) {
					System.out.print(map[i][j][k]);
					if(map[i][j][k]==1) {
						pq.add(new int[] {i,j,k});
					}
				}
				System.out.println();
			}
		}
		
		int[][] answer = new int[pq.size()][];
		int index=0;
		while(!pq.isEmpty()) {
			answer[index]=pq.poll();
			index++;
		}
		return answer;
	}
}
