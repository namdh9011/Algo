package y2021.m01.d31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2 1 5 3 4
 */


class Main_bj_2947_나무조각 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] trees = new int[5];
		boolean[] visit = new boolean[6];
		for(int i=0;i<5;i++) {
			trees[i]=Integer.parseInt(st.nextToken());
		}
		int esc = 0;
		while(esc<5) {
			for(int i=1;i<5;i++) {
				if(trees[i-1]>trees[i]) {
					int temp = trees[i-1];
					trees[i-1]=trees[i];
					trees[i]=temp;
					for(int j=0;j<5;j++) {
						if(!visit[trees[j]]&&trees[j]==j+1) {
							visit[trees[j]]=true;
							esc++;
						}
						System.out.print(trees[j] + " ");
					}
					System.out.println();
				}
			}
		}
	}
}