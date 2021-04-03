package y2021.m04.d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3_Kakao {

	public static void main(String[] args) {
//		int n = 100000;
//		int[] passenger = new int[n];
//		for(int i=0;i<n;i++) {
//			passenger[i]=10000;
//		}
//		int[][] train = new int[n-1][2];
//		for(int i=0;i<n-1;i++) {
//			train[i][0]=i+1;
//			train[i][1]=i+2;
//		}
		int n = 2;
		int[] passenger = {1,5}; 
		int[][] train = {{1,2}};
//		int n = 5;
//		int[] passenger = {1,1,2,3,4}; 
//		int[][] train = {{1,2},{1,3},{1,4},{1,5}};
//		int n = 4;
//		int[] passenger = {2,1,2,2}; 
//		int[][] train = {{1,2},{1,3},{2,4}};
//		int n = 6;
//		int[] passenger = {1,1,1,1,1,1}; 
//		int[][] train = {{1,2},{1,3},{1,4},{3,5},{3,6}};
		System.out.println(Arrays.toString(solution(n, passenger, train)));
	}
	public static ArrayList<ArrayList<Integer>> tree;
	public static int dest, dis;
	public static int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = new int[2];
        tree = new ArrayList<>();		//트리 생성
        dest = 1;						//최종 목적지 초기화
        dis = passenger[0];				//1번역만 방문할때 값
        int r = train.length;
        for(int i=0;i<n;i++) {			//0->1번 역 1->2번 역 ... n-1->n번 역 초기화
        	ArrayList<Integer> al = new ArrayList<>();
        	tree.add(al);
        }
        for(int i=0;i<r;i++) {			//양방향 트리 구성
        	tree.get(train[i][0]-1).add(train[i][1]-1);
        	tree.get(train[i][1]-1).add(train[i][0]-1);
        }
        bfs(n, passenger);
        answer[0]=dest;					//목적지
        answer[1]=dis;					//승객 수
        return answer;
    }
	public static void bfs(int n, int[] passenger) {
		boolean[] visit = new boolean[n];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,passenger[0]});	//출발역 q에 담기
		visit[0]=true;						//1번 역 방문처리
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			ArrayList<Integer> start = tree.get(curr[0]);
			for(int i=0;i<start.size();i++) {
				int next = start.get(i);	//갈 수 있는 역
				if(!visit[next]) {			//방문 안했으면
					visit[next]=true;		//방문 처리
					int nextdis = curr[1]+passenger[next];	//다음 역까지 승객수
					if(dis==nextdis) {
						dest = Math.max(dest,next+1);
					}else if(dis<nextdis) {
						dest = next+1;
						dis=nextdis;
					}
					q.add(new int[] {next, nextdis});	//다음역 넣어 줌.
				}
			}
		}
	}
}
