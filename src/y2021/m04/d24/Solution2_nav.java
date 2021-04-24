package y2021.m04.d24;

import java.util.Arrays;

public class Solution2_nav {
	public static void main(String[] args) {
//		int[][] blocks = {{0,50},{0,22},{2,10},{1,4},{4,-13}};
		int[][] blocks = {{0,92},{1,20},{2,11},{1,-81},{3,98}};
		System.out.println(Arrays.toString(solution(blocks)));
	}

	private static int[] solution(int[][] blocks) {
		int N = blocks.length;
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(map[i],-101);
		}
		for(int i=0;i<N;i++) {
			map[i][blocks[i][0]]=blocks[i][1];
		}
		for(int i=1;i<N;i++) {
			for(int count=0;count<i;count++) {
				for(int j=0;j<=i;j++) {
					if(map[i][j]==-101) {
						if(j==0) {
							if(map[i-1][j]!=-101&&map[i][j+1]!=-101) {
								map[i][j]=map[i-1][j]-map[i][j+1];
								break;
							}
						}else if(j==i) {
							if(map[i-1][j-1]!=-101&&map[i][j-1]!=-101) {
								map[i][j]=map[i-1][j-1]-map[i][j-1];
								break;
							}
						}else {
							if(map[i-1][j]!=-101&&map[i][j+1]!=-101) {
								map[i][j]=map[i-1][j]-map[i][j+1];
								break;
							}
							if(map[i-1][j-1]!=-101&&map[i][j-1]!=-101) {
								map[i][j]=map[i-1][j-1]-map[i][j-1];
								break;
							}
						}
					}
				}
			}
		}
		int[] answer = new int[(N*(N+1))/2];
		int index = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				answer[index]=map[i][j];
				index++;
			}
		}
		return answer;
	}
}
