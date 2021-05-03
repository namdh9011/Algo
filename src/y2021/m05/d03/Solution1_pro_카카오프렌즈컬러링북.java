package y2021.m05.d03;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1_pro_카카오프렌즈컬러링북 {
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println(solution(m, n, picture));
	}

	public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visit = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]&&picture[i][j]!=0){
                    numberOfArea++;
                    int count = bfs(picture, i, j, visit, m, n);
                    if(count>maxSizeOfOneArea){
                        maxSizeOfOneArea=count;
                    }
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static int bfs(int[][] picture, int i, int j, boolean[][] visit, int m, int n){
        Queue<int[]> q = new LinkedList<>();
        int color = picture[i][j];     //칸의 색
        int count = 1;                 //칸의 개수
        q.add(new int[] {i,j});
        visit[i][j]=true;
        int di[] = {0,-1,0,1};
        int dj[] = {-1,0,1,0};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int d=0;d<4;d++){
                int ni = curr[0] + di[d];
                int nj = curr[1] + dj[d];
                if(ni>=0&&nj>=0&&ni<m&&nj<n&&!visit[ni][nj]&&picture[ni][nj]==color){
                    count++;
                    visit[ni][nj]=true;
                    q.add(new int[] {ni,nj});
                }
            }
        }
        return count;
    }
}
