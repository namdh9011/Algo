package y2021.m02.d15;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
5
11100
2###1
3###1
2###1
12210

********************
5
11211
1###1
2###2
1###1
11211
 */

class Main_bj_2140_지뢰찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count=0;
		int map[][] = new int[N][N];
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=input.charAt(j)-'0';
			}
		}
		if(N>2) {
			if(map[0][0]==1) {
				map[1][1]=-1;
				count++;
			}else {
				map[1][1]=0;
			}
			for(int i=1;i<N-2;i++) {
				if(map[0][i]==0) {
					map[1][i+1]=0;
				}else if(map[0][i]==1) {
					if(map[1][i]==-1||map[1][i-1]==-1) {
						map[1][i+1]=0;
					}else {
						map[1][i+1]=-1;
						count++;
					}
				}else if(map[0][i]==2) {
					if(map[1][i]==-1&&map[1][i-1]==-1) {
						map[1][i+1]=0;
					}else {
						map[1][i+1]=-1;
						count++;
					}
				}else if(map[0][i]==3) {
					map[1][i+1]=-1;
					count++;
				}
				if(map[i][0]==0) {
					map[i+1][1]=0;
				}else if(map[i][0]==1) {
					if(map[i][1]==-1||map[i-1][1]==-1) {
						map[i+1][1]=0;
					}else {
						map[i+1][1]=-1;
						count++;
					}
				}else if(map[i][0]==2) {
					if(map[i][1]==-1&&map[i-1][1]==-1) {
						map[i+1][1]=0;
					}else {
						map[i+1][1]=-1;
						count++;
					}
				}else if(map[i][0]==3) {
					map[i+1][1]=-1;
					count++;
				}
			}
			for(int i=1;i<N-2;i++) {
				if(map[N-1][i]==0) {
					map[N-2][i+1]=0;
				}else if(map[N-1][i]==1) {
					if(map[N-2][i]==-1||map[N-2][i-1]==-1) {
						map[N-2][i+1]=0;
					}else {
						map[N-2][i+1]=-1;
						count++;
					}
				}else if(map[N-1][i]==2) {
					if(map[N-2][i]==-1&&map[N-2][i-1]==-1) {
						map[N-2][i+1]=0;
					}else {
						map[N-2][i+1]=-1;
						count++;
					}
				}else if(map[N-1][i]==3) {
					map[N-2][i+1]=-1;
					count++;
				}
				if(i==N-3) {
					break;
				}
				if(map[i][N-1]==0) {
					map[i+1][N-2]=0;
				}else if(map[i][N-1]==1) {
					if(map[i][N-2]==-1||map[i-1][N-2]==-1) {
						map[i+1][N-2]=0;
					}else {
						map[i+1][N-2]=-1;
						count++;
					}
				}else if(map[i][N-1]==2) {
					if(map[i][N-2]==-1&&map[i-1][N-2]==-1) {
						map[i+1][N-2]=0;
					}else {
						map[i+1][N-2]=-1;
						count++;
					}
				}else if(map[i][N-1]==3) {
					map[i+1][N-2]=-1;
					count++;
				}
			}
		}
		if(N>=5) {
			count+=(N-4)*(N-4);
		}
		System.out.println(count);
	}
}