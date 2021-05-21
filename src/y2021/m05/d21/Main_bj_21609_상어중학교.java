package y2021.m05.d21;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
메모리 : 24068KB
시간 : 152ms

최적 메모리 : 12968KB
최적 시간 : 124ms
*/
/*
5 3
2 2 -1 3 1
3 3 2 0 -1
0 0 0 1 2
-1 3 1 3 2
0 3 2 2 1
 */
public class Main_bj_21609_상어중학교 {
	public static int N,M,map[][],answer;
	public static boolean total_visit[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		answer=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//여기부터 여러번 돌려
		while(true) {
			ArrayList<BlockGroup> tar = new ArrayList<>();
			total_visit = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]>0&&!total_visit[i][j]) {
						total_visit[i][j]=true;
						BlockGroup temp = searchBlock(i,j);
						if(temp.size>1) tar.add(temp);
					}
				}
			}
			if(tar.size()==0) {
				break;
			}
			Collections.sort(tar);
			BlockGroup remo = tar.get(0);
			answer+=remo.size*remo.size;
			removeBlock(remo.block);
		}
		System.out.println(answer);
		
	}
	private static void removeBlock(ArrayList<int[]> block) {
		for(int i=0;i<block.size();i++) {
			int[] curr = block.get(i);
			map[curr[0]][curr[1]]=-2;
		}
		dropMap();
		spinMap();
		dropMap();
	}
	private static void spinMap() {
		int[][] temp_map = new int[N][N];
		for(int i=0;i<N;i++) {
			temp_map[i]=map[i].clone();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=temp_map[j][N-i-1];
			}
		}
	}
	private static void dropMap() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[N-1-j][i]==-2) {
					for(int k=N-2-j;k>=0;k--) {
						if(map[k][i]==-1) {
							break;
						}else if(map[k][i]>=0) {
							map[N-1-j][i]=map[k][i];
							map[k][i]=-2;
							break;
						}
					}
				}
			}
		}
	}
	private static BlockGroup searchBlock(int x, int y) {
		boolean[][] visit = new boolean[N][N];
		int di[] = {-1,0,1,0};
		int dj[] = {0,1,0,-1};
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		int num = map[x][y];
		int size = 1;
		int rainbow = 0;
		ArrayList<int[]> al = new ArrayList<>();
		al.add(new int[] {x,y});
		visit[x][y]=true;
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for(int d=0;d<di.length;d++) {
				int ni = curr[0] + di[d];
				int nj = curr[1] + dj[d];
				if(ni>=0&&nj>=0&&ni<N&&nj<N&&!visit[ni][nj]) {
					if(map[ni][nj]==0||map[ni][nj]==num) {
						if(map[ni][nj]==num) {
							total_visit[ni][nj]=true;
						}
						if(map[ni][nj]==0) {
							rainbow++;
						}
						visit[ni][nj]=true;
						size++;
						al.add(new int[] {ni,nj});
						q.add(new int[] {ni,nj});
					}
				}
			}
		}
		BlockGroup res = new BlockGroup(num, size, rainbow, x, y, al);
		return res;
	}
	public static class BlockGroup implements Comparable<BlockGroup>{
		int num;
		int size;
		int rainbow;
		int si;
		int sj;
		ArrayList<int[]> block;
		
		@Override
		public String toString() {
			return "BlockGroup [num=" + num + ", size=" + size + ", rainbow=" + rainbow + ", si=" + si + ", sj=" + sj
					+ ", block=" + block + "]";
		}

		public BlockGroup() {};
		public BlockGroup(int num, int size, int rainbow, int si, int sj, ArrayList<int[]> block) {
			this.num = num;
			this.size = size;
			this.rainbow = rainbow;
			this.si = si;
			this.sj = sj;
			this.block = block;
		}


		@Override
		public int compareTo(BlockGroup o) {
			if(this.size<o.size) {
				return 1;
			}else if(this.size==o.size) {
				if(this.rainbow<o.rainbow) {
					return 1;
				}else if(this.rainbow==o.rainbow) {
					if(this.si<o.si) {
						return 1;
					}if(this.si==o.si) {
						return o.sj-this.sj;
					}
				}
			}
			return -1;
		}
	}
}


