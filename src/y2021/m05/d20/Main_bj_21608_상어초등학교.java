package y2021.m05.d20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
/*
메모리 : 16524KB
시간 : 156ms

최적 메모리 : 14184KB
최적 시간 : 116ms
*/
/*
3
4 2 5 1 7
3 1 9 4 5
9 8 1 2 3
8 1 9 3 4
7 2 3 4 8
1 9 2 5 7
6 5 2 3 4
5 1 9 2 8
2 9 3 1 4
 */
public class Main_bj_21608_상어초등학교 {
	public static int blankmap[][], map[][], N, di[] = {-1,1,0,0}, dj[] = {0,0,-1,1};
	public static ArrayList<HashSet<Integer>> like_friend;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		blankmap = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				blankmap[i][j]=4;
				if(i==0||j==0||i==N-1||j==N-1) {
					blankmap[i][j]=3;
				}
				if((i==0&&j==0)||(i==0&&j==N-1)||(i==N-1&&j==0)||(i==N-1&&j==N-1)) {
					blankmap[i][j]=2;
				}
			}
		}
		map = new int[N][N];
		StringTokenizer st;
		like_friend = new ArrayList<>();
		for(int i=0;i<N*N+1;i++) {
			like_friend.add(new HashSet<>());
		}
		for(int i=0;i<N*N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			HashSet<Integer> curr_like = like_friend.get(num);
			for(int j=0;j<4;j++) {
				int friend = Integer.parseInt(st.nextToken());
				curr_like.add(friend);
			}
			position(num,curr_like);
		}
		
		System.out.println(satisfied());
	}
	private static int satisfied() {
		int sum = 0;
		int[] score = {0,1,10,100,1000};
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int tar = map[i][j];
				int sati = 0;
				for(int d=0;d<4;d++) {
					int ni = i+di[d];
					int nj = j+dj[d];
					if(ni>=0&&nj>=0&&ni<N&&nj<N&&like_friend.get(tar).contains(map[ni][nj])) {
						sati++;
					}
				}
				sum+=score[sati];
			}
		}
		return sum;
	}
	public static void position(int num, HashSet<Integer> like) {
		int selecti=0;
		int selectj=0;
		int maxlike = -1;
		int maxblank = -1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==0) {
					int likecount = 0;
					for(int d=0;d<4;d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if(ni>=0&&nj>=0&&ni<N&&nj<N) {
							if(map[ni][nj]!=0&&like.contains(map[ni][nj])) {
								likecount++;
							}
						}
					}
					if(maxlike<likecount) {
						maxlike=likecount;
						maxblank = blankmap[i][j];
						selecti=i;
						selectj=j;
					}else if(maxlike==likecount) {
						if(blankmap[i][j]>maxblank) {
							maxblank=blankmap[i][j];
							selecti=i;
							selectj=j;
						}
					}
				}
			}
		}
		map[selecti][selectj]=num;
		for(int d=0;d<4;d++) {
			int ni = selecti + di[d];
			int nj = selectj + dj[d];
			if(ni>=0&&nj>=0&&ni<N&&nj<N) {
				blankmap[ni][nj]--;
			}
		}
	}
}


